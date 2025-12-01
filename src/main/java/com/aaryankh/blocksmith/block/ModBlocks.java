package com.aaryankh.blocksmith.block;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.block.custom.MystiteBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Blocksmith.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Blocksmith.MOD_ID, name), block);
    }

    public static final Block HEARTWOOD_BLOCK = registerBlock("heartwood_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
            )
    );

    public static final Block VERDANITE_ORE = registerBlock("verdanite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            )
    );

    public static final Block DEEPSLATE_VERDANITE_ORE = registerBlock("deepslate_verdanite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            )
    );

    public static final Block VERDANITE_BLOCK = registerBlock("verdanite_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            )
    );

    public static final Block MYSTITE_BLOCK = registerBlock("mystite_block",
            new MystiteBlock(AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.GRASS)
            )
    );

    public static void registerModBlocks() {
        Blocksmith.LOGGER.info("Registering ModBlocks for: " + Blocksmith.MOD_ID);
    }
}
