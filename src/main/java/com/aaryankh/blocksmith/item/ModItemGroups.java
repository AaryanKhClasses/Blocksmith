package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BLOCKSMITH_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(Blocksmith.MOD_ID, "blocksmith_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.HEARTWOOD_BLOCK))
                    .displayName(Text.translatable("itemgroup.blocksmith.blocksmith_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.HEARTWOOD_CHUNK);
                        entries.add(ModItems.RAW_VERDANITE);
                        entries.add(ModItems.VERDANITE_INGOT);
                        entries.add(ModItems.VERDANITE_CHISEL);
                        entries.add(ModItems.VERDANITE_APPLE);
                        entries.add(ModItems.MYSTITE_COAL);

                        entries.add(ModBlocks.HEARTWOOD_BLOCK);
                        entries.add(ModBlocks.HEARTWOOD_STAIRS);
                        entries.add(ModBlocks.HEARTWOOD_SLAB);
                        entries.add(ModBlocks.HEARTWOOD_BUTTON);
                        entries.add(ModBlocks.HEARTWOOD_PRESSURE_PLATE);
                        entries.add(ModBlocks.HEARTWOOD_TRAPDOOR);
                        entries.add(ModBlocks.HEARTWOOD_DOOR);
                        entries.add(ModBlocks.HEARTWOOD_FENCE);
                        entries.add(ModBlocks.HEARTWOOD_FENCE_GATE);
                        entries.add(ModBlocks.HEARTWOOD_WALL);
                        entries.add(ModBlocks.VERDANITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_VERDANITE_ORE);
                        entries.add(ModBlocks.VERDANITE_BLOCK);
                        entries.add(ModBlocks.MYSTITE_BLOCK);
                    }).build()
    );

    public static void registerItemGroups() {
        Blocksmith.LOGGER.info("Registering Blocksmith for: " + Blocksmith.MOD_ID);
    }
}
