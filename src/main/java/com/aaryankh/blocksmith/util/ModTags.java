package com.aaryankh.blocksmith.util;

import com.aaryankh.blocksmith.Blocksmith;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_VERDANITE_TOOL = createTag("needs_verdanite_tool");
        public static final TagKey<Block> INCORRECT_FOR_VERDANITE_TOOL = createTag("incorrect_for_verdanite_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Blocksmith.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MYSTITE_CONVERTIBLE = createTag("mystite_convertible");
        public static final TagKey<Item> LIGHTNING_ENCHANTABLE = createTag("lightning_enchantable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Blocksmith.MOD_ID, name));
        }
    }
}
