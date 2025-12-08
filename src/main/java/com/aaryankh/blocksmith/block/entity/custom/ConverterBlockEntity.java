package com.aaryankh.blocksmith.block.entity.custom;

import com.aaryankh.blocksmith.block.entity.ImplementedInventory;
import com.aaryankh.blocksmith.block.entity.ModBlockEntities;
import com.aaryankh.blocksmith.recipe.ConverterBlockRecipe;
import com.aaryankh.blocksmith.recipe.ConverterBlockRecipeInput;
import com.aaryankh.blocksmith.recipe.ModRecipes;
import com.aaryankh.blocksmith.screen.custom.ConverterBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ConverterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inv = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100;

    public ConverterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CONVERTER_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch(index) {
                    case 0 -> ConverterBlockEntity.this.progress;
                    case 1 -> ConverterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch(index) {
                    case 0 -> ConverterBlockEntity.this.progress = value;
                    case 1 -> ConverterBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inv;
    }

    @Override
    public Object getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.blocksmith.converter_block");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ConverterBlockScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world1, BlockPos pos, BlockState state) {
        if(hasRecipe()) {
            this.progress++;
            markDirty(world1, pos, state);
            if(this.progress >= this.maxProgress) {
                craftItem();
                this.progress = 0;
                this.maxProgress = 100;
            }
        } else {
            this.progress = 0;
            this.maxProgress = 100;
        }
    }

    private void craftItem() {
        assert this.getWorld() != null;
        Optional<RecipeEntry<ConverterBlockRecipe>> recipe = this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.CONVERTER_BLOCK_TYPE, new ConverterBlockRecipeInput(inv.get(INPUT_SLOT)), this.getWorld());
        ItemStack output = recipe.get().value().output();
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(), this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean hasRecipe() {
        assert this.getWorld() != null;
        Optional<RecipeEntry<ConverterBlockRecipe>> recipe = this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.CONVERTER_BLOCK_TYPE, new ConverterBlockRecipeInput(inv.get(INPUT_SLOT)), this.getWorld());
        if(recipe.isEmpty()) return false;
        ItemStack output = recipe.get().value().output();

        return canInsertItemIntoOutputSlot(output) && canInsertAmountIntoOutputSlot(output.getCount());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();
        return currentCount + count <= maxCount;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inv, registryLookup);
        nbt.putInt("converter_block.progress", progress);
        nbt.putInt("converter_block.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inv, registryLookup);
        progress = nbt.getInt("converter_block.progress");
        maxProgress = nbt.getInt("converter_block.max_progress");
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
