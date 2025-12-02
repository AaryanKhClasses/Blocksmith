package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VERDANITE_BLOCK);
        addDrop(ModBlocks.HEARTWOOD_BLOCK);
        addDrop(ModBlocks.MYSTITE_BLOCK);
        addDrop(ModBlocks.VERDANITE_ORE, oreDrops(ModBlocks.VERDANITE_ORE, ModItems.RAW_VERDANITE));
        addDrop(ModBlocks.DEEPSLATE_VERDANITE_ORE, oreDrops(ModBlocks.DEEPSLATE_VERDANITE_ORE, ModItems.RAW_VERDANITE));
    }
}
