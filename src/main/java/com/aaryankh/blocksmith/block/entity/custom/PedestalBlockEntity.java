package com.aaryankh.blocksmith.block.entity.custom;

import com.aaryankh.blocksmith.block.entity.ImplementedInventory;
import com.aaryankh.blocksmith.block.entity.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private float rotation = 0f;

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PEDESTAL_BE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inv;
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState oldState) {
        ItemScatterer.spawn(world, pos, (this));
        super.onBlockReplaced(pos, oldState);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) rotation = 0;
        return rotation;
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        Inventories.writeData(view, inv);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        Inventories.readData(view, inv);
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
