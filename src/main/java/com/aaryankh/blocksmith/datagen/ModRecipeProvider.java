package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> VERDANITE_SMELTABLE = List.of(ModBlocks.VERDANITE_ORE, ModBlocks.DEEPSLATE_VERDANITE_ORE, ModItems.RAW_VERDANITE);

        offerSmelting(recipeExporter, VERDANITE_SMELTABLE, RecipeCategory.MISC, ModItems.VERDANITE_INGOT, 0.25f, 200, "verdanite_ingot");
        offerBlasting(recipeExporter, VERDANITE_SMELTABLE, RecipeCategory.MISC, ModItems.VERDANITE_INGOT, 0.25f, 100, "verdanite_ingot");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.HEARTWOOD_CHUNK, RecipeCategory.DECORATIONS, ModBlocks.HEARTWOOD_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.VERDANITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.VERDANITE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.MYSTITE_COAL, RecipeCategory.DECORATIONS, ModBlocks.MYSTITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANITE_APPLE)
                .pattern("III")
                .pattern("IAI")
                .pattern("III")
                .input('I', ModItems.VERDANITE_INGOT)
                .input('A', Items.APPLE)
                .criterion(hasItem(ModItems.VERDANITE_APPLE), conditionsFromItem(ModItems.VERDANITE_APPLE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.VERDANITE_CHISEL)
                .pattern("  I")
                .pattern(" S ")
                .pattern("S  ")
                .input('I', ModItems.VERDANITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.VERDANITE_CHISEL), conditionsFromItem(ModItems.VERDANITE_CHISEL))
                .offerTo(recipeExporter);
    }
}
