package com.aaryankh.blocksmith;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.block.entity.ModBlockEntities;
import com.aaryankh.blocksmith.enchantment.ModEnchantmentEffects;
import com.aaryankh.blocksmith.item.ModItemGroups;
import com.aaryankh.blocksmith.item.ModItems;
import com.aaryankh.blocksmith.recipe.ModRecipes;
import com.aaryankh.blocksmith.screen.ModScreenHandlers;
import com.aaryankh.blocksmith.util.HammerUsageEvent;
import com.aaryankh.blocksmith.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blocksmith implements ModInitializer {
    public static final String MOD_ID = "blocksmith";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Blocksmith Mod...");
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEnchantmentEffects.registerEnchantmentEffects();
        ModWorldGeneration.generateModWorldGen();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModRecipes.registerRecipes();

        FuelRegistry.INSTANCE.add(ModItems.MYSTITE_COAL, 20000);
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}
