package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool heartwoodPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.HEARTWOOD_BLOCK);
        heartwoodPool.stairs(ModBlocks.HEARTWOOD_STAIRS);
        heartwoodPool.slab(ModBlocks.HEARTWOOD_SLAB);
        heartwoodPool.button(ModBlocks.HEARTWOOD_BUTTON);
        heartwoodPool.pressurePlate(ModBlocks.HEARTWOOD_PRESSURE_PLATE);
        heartwoodPool.fence(ModBlocks.HEARTWOOD_FENCE);
        heartwoodPool.fenceGate(ModBlocks.HEARTWOOD_FENCE_GATE);
        heartwoodPool.wall(ModBlocks.HEARTWOOD_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.HEARTWOOD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.HEARTWOOD_TRAPDOOR);

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
        itemModelGenerator.register(ModItems.MYSTITE_HAMMER, Models.HANDHELD);
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.MYSTITE_BOOTS));

        itemModelGenerator.register(ModItems.VERDANITE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANITE_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.VERDANITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VERDANITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VERDANITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VERDANITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VERDANITE_HOE, Models.HANDHELD);
    }
}
