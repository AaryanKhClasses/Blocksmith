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
                        entries.add(ModBlocks.HEARTWOOD_BLOCK);
                        entries.add(ModBlocks.VERDANITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_VERDANITE_ORE);
                        entries.add(ModBlocks.VERDANITE_BLOCK);
                    }).build()
    );

    public static void registerItemGroups() {
        Blocksmith.LOGGER.info("Registering Blocksmith for: " + Blocksmith.MOD_ID);
    }
}
