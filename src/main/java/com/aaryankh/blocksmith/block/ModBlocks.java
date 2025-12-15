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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Blocksmith.MOD_ID, name), new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Blocksmith.MOD_ID, name)))));
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Blocksmith.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Blocksmith.MOD_ID, name), toRegister);
    }

    public static final Block HEARTWOOD_BLOCK = registerBlock("heartwood_block", properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_STAIRS = registerBlock("heartwood_stairs", properties -> new StairsBlock(ModBlocks.HEARTWOOD_BLOCK.getDefaultState(), properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_SLAB = registerBlock("heartwood_slab", properties -> new SlabBlock(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_BUTTON = registerBlock("heartwood_button", properties -> new ButtonBlock(BlockSetType.OAK, 2, properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().noCollision()));
    public static final Block HEARTWOOD_PRESSURE_PLATE = registerBlock("heartwood_pressure_plate", properties -> new PressurePlateBlock(BlockSetType.OAK, properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_TRAPDOOR = registerBlock("heartwood_trapdoor", properties -> new TrapdoorBlock(BlockSetType.OAK, properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));
    public static final Block HEARTWOOD_DOOR = registerBlock("heartwood_door", properties -> new DoorBlock(BlockSetType.OAK, properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));
    public static final Block HEARTWOOD_FENCE = registerBlock("heartwood_fence", properties -> new FenceBlock(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_FENCE_GATE = registerBlock("heartwood_fence_gate", properties -> new FenceGateBlock(WoodType.OAK, properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block HEARTWOOD_WALL = registerBlock("heartwood_wall", properties -> new WallBlock(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block VERDANITE_ORE = registerBlock("verdanite_ore", properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), properties.strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block DEEPSLATE_VERDANITE_ORE = registerBlock("deepslate_verdanite_ore", properties -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), properties.strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block VERDANITE_BLOCK = registerBlock("verdanite_block", properties -> new Block(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block MYSTITE_BLOCK = registerBlock("mystite_block", properties -> new MystiteBlock(properties.strength(4f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block PEDESTAL_BLOCK = registerBlock("pedestal_block", properties -> new PedestalBlock(properties.strength(4f).requiresTool().nonOpaque().sounds(BlockSoundGroup.STONE)));
    public static final Block CONVERTER_BLOCK = registerBlock("converter_block", properties -> new ConverterBlock(properties.strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static void registerModBlocks() {
        Blocksmith.LOGGER.info("Registering ModBlocks for: " + Blocksmith.MOD_ID);
    }
}
