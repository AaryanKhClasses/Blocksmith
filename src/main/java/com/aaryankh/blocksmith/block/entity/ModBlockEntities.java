package com.aaryankh.blocksmith.block.entity;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.block.entity.custom.ConverterBlockEntity;
import com.aaryankh.blocksmith.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Blocksmith.MOD_ID, "pedestal_be"),
            BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL_BLOCK).build(null));

    public static final BlockEntityType<ConverterBlockEntity> CONVERTER_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Blocksmith.MOD_ID, "converter_be"),
            BlockEntityType.Builder.create(ConverterBlockEntity::new, ModBlocks.CONVERTER_BLOCK).build(null));

    public static void registerBlockEntities() {
        Blocksmith.LOGGER.info("Registering Block Entities for " + Blocksmith.MOD_ID);
    }
}
