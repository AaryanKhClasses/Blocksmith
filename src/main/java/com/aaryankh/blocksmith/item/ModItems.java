package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Blocksmith.MOD_ID, name), item);
    };

    public static final Item HEARTWOOD_CHUNK = registerItem("heartwood_chunk", new Item(new Item.Settings()));
    public static final Item RAW_VERDANITE = registerItem("raw_verdanite", new Item(new Item.Settings()));
    public static final Item VERDANITE_INGOT = registerItem("verdanite_ingot", new Item(new Item.Settings()));

    public static void registerModItems() {
        Blocksmith.LOGGER.info("Registering ModItems for: " + Blocksmith.MOD_ID);
    }
}
