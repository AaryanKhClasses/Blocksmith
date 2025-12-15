package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> MYSTITE_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Blocksmith.MOD_ID, "mystite"));

    public static final ArmorMaterial MYSTITE_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), map -> {
            map.put(EquipmentType.BOOTS, 2);
            map.put(EquipmentType.LEGGINGS, 5);
            map.put(EquipmentType.CHESTPLATE, 7);
            map.put(EquipmentType.HELMET, 3);
            map.put(EquipmentType.BODY, 10);
    }), 22, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F, 0.2F, ModTags.Items.MYSTITE_REPAIR, MYSTITE_KEY);
}
