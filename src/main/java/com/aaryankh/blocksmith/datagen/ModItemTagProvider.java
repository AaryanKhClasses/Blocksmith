package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.item.ModItems;
import com.aaryankh.blocksmith.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.MYSTITE_CONVERTIBLE)
                .add(Items.ANCIENT_DEBRIS)
                .add(Items.NETHERITE_SCRAP);

        valueLookupBuilder(ModTags.Items.MYSTITE_REPAIR)
                .add(ModItems.MYSTITE_COAL);

        valueLookupBuilder(ModTags.Items.LIGHTNING_ENCHANTABLE).add(ModItems.MYSTITE_HAMMER);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.VERDANITE_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.VERDANITE_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(ModItems.VERDANITE_AXE);
        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.VERDANITE_SHOVEL);
        valueLookupBuilder(ItemTags.HOES).add(ModItems.VERDANITE_HOE);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MYSTITE_HELMET)
                .add(ModItems.MYSTITE_CHESTPLATE)
                .add(ModItems.MYSTITE_LEGGINGS)
                .add(ModItems.MYSTITE_BOOTS);
    }
}
