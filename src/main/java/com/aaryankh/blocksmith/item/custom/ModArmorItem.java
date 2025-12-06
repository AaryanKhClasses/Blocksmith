package com.aaryankh.blocksmith.item.custom;

import com.aaryankh.blocksmith.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, List.of(
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, -1, 1, false, false),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 0, false, false)
                    )).build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSetOfArmorOn(player)) evaluateArmorEffects(player);
                else removeArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            RegistryEntry<ArmorMaterial> armorMaterial = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();
            if(hasCorrectArmorOn(armorMaterial, player)) addStatusEffectForMaterial(player, armorMaterial, effects);
            else removeStatusEffectForMaterial(player, effects);
        }
    }

    private void removeArmorEffects(PlayerEntity player) {
        for(Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            List<StatusEffectInstance> effects = entry.getValue();
            removeStatusEffectForMaterial(player, effects);
        }
    }

    private void removeStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> effects) {
        for(StatusEffectInstance instance : effects) player.removeStatusEffect(instance.getEffectType());
    }

    private void addStatusEffectForMaterial(PlayerEntity player, RegistryEntry<ArmorMaterial> material, List<StatusEffectInstance> effects) {
        boolean hasEffect = effects.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));
        if(!hasEffect) {
            for(StatusEffectInstance instance : effects) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(), instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSetOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player) {
        for(ItemStack armorStack : player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) return false;
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
