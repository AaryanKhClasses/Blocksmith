package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.block.ModBlocks;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> MYSTITE_ARMOR_MATERIAL = registerArmorMaterial("mystite",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
            }), 22, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, () -> Ingredient.ofItems(ModBlocks.MYSTITE_BLOCK), List.of(new ArmorMaterial.Layer(Identifier.of(Blocksmith.MOD_ID, "mystite"))), 1.5F, 0.2F));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> armorMaterial) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(Blocksmith.MOD_ID, name), armorMaterial.get());
    }
}
