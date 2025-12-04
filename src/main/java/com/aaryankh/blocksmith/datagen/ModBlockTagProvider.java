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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VERDANITE_ORE)
                .add(ModBlocks.DEEPSLATE_VERDANITE_ORE)
                .add(ModBlocks.VERDANITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
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

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.MYSTITE_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VERDANITE_ORE)
                .add(ModBlocks.DEEPSLATE_VERDANITE_ORE);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.HEARTWOOD_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.HEARTWOOD_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.HEARTWOOD_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.HEARTWOOD_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.HEARTWOOD_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.HEARTWOOD_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.HEARTWOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.HEARTWOOD_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.HEARTWOOD_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_VERDANITE_TOOL).forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
