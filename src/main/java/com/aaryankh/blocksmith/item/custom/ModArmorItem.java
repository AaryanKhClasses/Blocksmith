package com.aaryankh.blocksmith.item.custom;

import com.aaryankh.blocksmith.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends Item {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, List.of(
                            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, -1, 1, false, false),
                            new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 0, false, false)
                    )).build();

    public ModArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSetOfArmorOn(player)) evaluateArmorEffects(player);
                else removeArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            List<StatusEffectInstance> effects = entry.getValue();
            if(hasCorrectArmorOn(armorMaterial, player)) addStatusEffectForMaterial(player, armorMaterial, effects);
            else removeStatusEffectForMaterial(player, effects);
        }
    }

    private void removeArmorEffects(PlayerEntity player) {
        for(Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            List<StatusEffectInstance> effects = entry.getValue();
            removeStatusEffectForMaterial(player, effects);
        }
    }

    private void removeStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> effects) {
        for(StatusEffectInstance instance : effects) player.removeStatusEffect(instance.getEffectType());
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial material, List<StatusEffectInstance> effects) {
        boolean hasEffect = effects.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));
        if(!hasEffect) {
            for(StatusEffectInstance instance : effects) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(), instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSetOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        ItemStack boots = player.getInventory().getStack(EquipmentSlot.FEET.getIndex());
        ItemStack leggings = player.getInventory().getStack(EquipmentSlot.LEGS.getIndex());
        ItemStack chestplate = player.getInventory().getStack(EquipmentSlot.CHEST.getIndex());
        ItemStack helmet = player.getInventory().getStack(EquipmentSlot.HEAD.getIndex());

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentChestplate = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        return equippableComponentBoots.assetId().get().equals(material.assetId()) && equippableComponentLeggings.assetId().get().equals(material.assetId()) && equippableComponentChestplate.assetId().get().equals(material.assetId()) && equippableComponentHelmet.assetId().get().equals(material.assetId());
    }
}
