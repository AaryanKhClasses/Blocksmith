package com.aaryankh.blocksmith.block;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.block.custom.ConverterBlock;
import com.aaryankh.blocksmith.block.custom.MystiteBlock;
import com.aaryankh.blocksmith.block.custom.PedestalBlock;
import net.minecraft.block.*;
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

    public static final Block HEARTWOOD_BLOCK = registerBlock("heartwood_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_STAIRS = registerBlock("heartwood_stairs", new StairsBlock(ModBlocks.HEARTWOOD_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_SLAB = registerBlock("heartwood_slab", new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_BUTTON = registerBlock("heartwood_button", new ButtonBlock(BlockSetType.OAK, 2, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().noCollision()));
    public static final Block HEARTWOOD_PRESSURE_PLATE = registerBlock("heartwood_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_TRAPDOOR = registerBlock("heartwood_trapdoor", new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));
    public static final Block HEARTWOOD_DOOR = registerBlock("heartwood_door", new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));
    public static final Block HEARTWOOD_FENCE = registerBlock("heartwood_fence", new FenceBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_FENCE_GATE = registerBlock("heartwood_fence_gate", new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_WALL = registerBlock("heartwood_wall", new WallBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block VERDANITE_ORE = registerBlock("verdanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_VERDANITE_ORE = registerBlock("deepslate_verdanite_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block VERDANITE_BLOCK = registerBlock("verdanite_block", new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block MYSTITE_BLOCK = registerBlock("mystite_block", new MystiteBlock(AbstractBlock.Settings.create().strength(4f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PEDESTAL_BLOCK = registerBlock("pedestal_block", new PedestalBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque().sounds(BlockSoundGroup.STONE)));
    public static final Block CONVERTER_BLOCK = registerBlock("converter_block", new ConverterBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static void registerModBlocks() {
        Blocksmith.LOGGER.info("Registering ModBlocks for: " + Blocksmith.MOD_ID);
    }
}
