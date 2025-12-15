package com.aaryankh.blocksmith.screen.custom;

import com.aaryankh.blocksmith.block.entity.custom.ConverterBlockEntity;
import com.aaryankh.blocksmith.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class ConverterBlockScreenHandler extends ScreenHandler {
    private final Inventory inv;
    private final PropertyDelegate propertyDelegate;
    public final ConverterBlockEntity blockEntity;

    public ConverterBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getEntityWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }

    public ConverterBlockScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(ModScreenHandlers.CONVERTER_BLOCK_SCREEN_HANDLER, syncId);
        this.inv = ((Inventory) blockEntity);
        this.blockEntity = (ConverterBlockEntity) blockEntity;
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new Slot(this.inv, 0, 54, 34));
        this.addSlot(new Slot(this.inv, 1, 104, 34));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return this.propertyDelegate.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowWidth = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowWidth / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inv.size()) {
                if (!this.insertItem(originalStack, this.inv.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inv.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inv.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
