package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HEARTWOOD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VERDANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VERDANITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HEARTWOOD_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VERDANITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYSTITE_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANITE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANITE_CHISEL, Models.GENERATED);
    }
}
