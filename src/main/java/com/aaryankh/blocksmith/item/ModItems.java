package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.item.custom.ChiselItem;
import com.aaryankh.blocksmith.item.custom.HammerItem;
import com.aaryankh.blocksmith.item.custom.ModArmorItem;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Blocksmith.MOD_ID, name), item);
    }

    public static final Item HEARTWOOD_CHUNK = registerItem("heartwood_chunk", new Item(new Item.Settings()));
    public static final Item RAW_VERDANITE = registerItem("raw_verdanite", new Item(new Item.Settings()));
    public static final Item VERDANITE_INGOT = registerItem("verdanite_ingot", new Item(new Item.Settings()));

    public static final Item VERDANITE_CHISEL = registerItem("verdanite_chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item VERDANITE_SWORD = registerItem("verdanite_sword", new SwordItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VERDANITE, 3, -2.4F))));
    public static final Item VERDANITE_PICKAXE = registerItem("verdanite_pickaxe", new PickaxeItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VERDANITE, 1.0F, -2.8F))));
    public static final Item VERDANITE_AXE = registerItem("verdanite_axe", new AxeItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.VERDANITE, 6.0F, -3.1F))));
    public static final Item VERDANITE_SHOVEL = registerItem("verdanite_shovel", new ShovelItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.VERDANITE, 1.5F, -3.0F))));
    public static final Item VERDANITE_HOE = registerItem("verdanite_hoe", new HoeItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.VERDANITE, -2.0F, -1.0F))));
    public static final Item VERDANITE_APPLE = registerItem("verdanite_apple", new Item(new Item.Settings().food(ModFoodComponents.VERDANITE_APPLE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.blocksmith.verdanite_apple"));
        }
    });
    public static final Item MYSTITE_COAL = registerItem("mystite_coal", new Item(new Item.Settings()));
    public static final Item MYSTITE_HAMMER = registerItem("mystite_hammer", new HammerItem(ModToolMaterials.VERDANITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VERDANITE, 6.0F, -4.0F))));
    public static final Item MYSTITE_BOW = registerItem("mystite_bow", new BowItem(new Item.Settings().maxDamage(1024)));
    public static final Item MYSTITE_HELMET = registerItem("mystite_helmet", new ModArmorItem(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(35))));
    public static final Item MYSTITE_CHESTPLATE = registerItem("mystite_chestplate", new ArmorItem(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(35))));
    public static final Item MYSTITE_LEGGINGS = registerItem("mystite_leggings", new ArmorItem(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(35))));
    public static final Item MYSTITE_BOOTS = registerItem("mystite_boots", new ArmorItem(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(35))));

    public static void registerModItems() {
        Blocksmith.LOGGER.info("Registering ModItems for: " + Blocksmith.MOD_ID);
    }
}
