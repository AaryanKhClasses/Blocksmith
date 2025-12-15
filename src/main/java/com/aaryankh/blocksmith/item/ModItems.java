package com.aaryankh.blocksmith.item;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.item.custom.ChiselItem;
import com.aaryankh.blocksmith.item.custom.HammerItem;
import com.aaryankh.blocksmith.item.custom.ModArmorItem;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Blocksmith.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Blocksmith.MOD_ID, name)))));
    }

    public static final Item HEARTWOOD_CHUNK = registerItem("heartwood_chunk", Item::new);
    public static final Item RAW_VERDANITE = registerItem("raw_verdanite", Item::new);
    public static final Item VERDANITE_INGOT = registerItem("verdanite_ingot", Item::new);

    public static final Item VERDANITE_CHISEL = registerItem("verdanite_chisel", setting -> new ChiselItem(setting.maxDamage(32)));
    public static final Item VERDANITE_SWORD = registerItem("verdanite_sword", setting -> new Item(setting.sword(ModToolMaterials.VERDANITE, 3, -2.4F)));
    public static final Item VERDANITE_PICKAXE = registerItem("verdanite_pickaxe", setting -> new Item(setting.pickaxe(ModToolMaterials.VERDANITE, 1.0F, -2.8F)));
    public static final Item VERDANITE_AXE = registerItem("verdanite_axe", setting -> new AxeItem(ModToolMaterials.VERDANITE, 6.0F, -3.1F, setting));
    public static final Item VERDANITE_SHOVEL = registerItem("verdanite_shovel", setting -> new ShovelItem(ModToolMaterials.VERDANITE, 1.5F, -3.0F, setting));
    public static final Item VERDANITE_HOE = registerItem("verdanite_hoe", setting -> new HoeItem(ModToolMaterials.VERDANITE, -2.0F, -1.0F, setting));
    public static final Item VERDANITE_APPLE = registerItem("verdanite_apple", setting -> new Item(setting.food(ModFoodComponents.VERDANITE_APPLE, ModFoodComponents.VERDANITE_APPLE_EFFECT)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip.blocksmith.verdanite_apple"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item MYSTITE_COAL = registerItem("mystite_coal", Item::new);
    public static final Item MYSTITE_HAMMER = registerItem("mystite_hammer", setting -> new HammerItem(ModToolMaterials.VERDANITE, 6.0F, -4.0F, setting));
    public static final Item MYSTITE_BOW = registerItem("mystite_bow", setting -> new BowItem(setting.maxDamage(1024)));
    public static final Item MYSTITE_HELMET = registerItem("mystite_helmet", setting -> new ModArmorItem(setting.armor(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, EquipmentType.HELMET)));
    public static final Item MYSTITE_CHESTPLATE = registerItem("mystite_chestplate", setting -> new Item(setting.armor(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)));
    public static final Item MYSTITE_LEGGINGS = registerItem("mystite_leggings", setting -> new Item(setting.armor(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)));
    public static final Item MYSTITE_BOOTS = registerItem("mystite_boots", setting -> new Item(setting.armor(ModArmorMaterials.MYSTITE_ARMOR_MATERIAL, EquipmentType.BOOTS)));

    public static void registerModItems() {
        Blocksmith.LOGGER.info("Registering ModItems for: " + Blocksmith.MOD_ID);
    }
}
