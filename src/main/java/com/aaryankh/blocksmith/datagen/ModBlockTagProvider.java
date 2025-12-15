package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VERDANITE_ORE)
                .add(ModBlocks.DEEPSLATE_VERDANITE_ORE)
                .add(ModBlocks.VERDANITE_BLOCK)
                .add(ModBlocks.PEDESTAL_BLOCK)
                .add(ModBlocks.CONVERTER_BLOCK);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.HEARTWOOD_BLOCK)
                .add(ModBlocks.HEARTWOOD_STAIRS)
                .add(ModBlocks.HEARTWOOD_SLAB)
                .add(ModBlocks.HEARTWOOD_BUTTON)
                .add(ModBlocks.HEARTWOOD_PRESSURE_PLATE)
                .add(ModBlocks.HEARTWOOD_TRAPDOOR)
                .add(ModBlocks.HEARTWOOD_DOOR)
                .add(ModBlocks.HEARTWOOD_FENCE)
                .add(ModBlocks.HEARTWOOD_FENCE_GATE)
                .add(ModBlocks.HEARTWOOD_WALL);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.MYSTITE_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VERDANITE_ORE)
                .add(ModBlocks.DEEPSLATE_VERDANITE_ORE);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.HEARTWOOD_STAIRS);
        valueLookupBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.HEARTWOOD_SLAB);
        valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.HEARTWOOD_BUTTON);
        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.HEARTWOOD_PRESSURE_PLATE);
        valueLookupBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.HEARTWOOD_DOOR);
        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.HEARTWOOD_TRAPDOOR);
        valueLookupBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.HEARTWOOD_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.HEARTWOOD_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.HEARTWOOD_WALL);

        valueLookupBuilder(ModTags.Blocks.NEEDS_VERDANITE_TOOL).forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN).add(ModBlocks.HEARTWOOD_BLOCK);
    }
}
