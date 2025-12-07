package com.aaryankh.blocksmith.enchantment;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.enchantment.custom.LightningHitterEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_HITTER_EFFECT = registerEntityEffect("lightning_hitter", LightningHitterEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Blocksmith.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Blocksmith.LOGGER.info("Registering Mod Enchantment Effects for " + Blocksmith.MOD_ID);
    }
}
