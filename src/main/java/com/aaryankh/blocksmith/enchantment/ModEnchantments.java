package com.aaryankh.blocksmith.enchantment;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.enchantment.custom.LightningHitterEnchantmentEffect;
import com.aaryankh.blocksmith.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> LIGHTNING_HITTER = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Blocksmith.MOD_ID, "lightning_hitter"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, LIGHTNING_HITTER, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.LIGHTNING_ENCHANTABLE),
                items.getOrThrow(ModTags.Items.LIGHTNING_ENCHANTABLE),
                5, 2,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25, 9),
                2,
                AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK, EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM, new LightningHitterEnchantmentEffect())
        );
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
