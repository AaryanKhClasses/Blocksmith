package com.aaryankh.blocksmith.datagen;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> VERDANITE_SMELTABLE = List.of(ModBlocks.VERDANITE_ORE, ModBlocks.DEEPSLATE_VERDANITE_ORE, ModItems.RAW_VERDANITE);

                offerSmelting(VERDANITE_SMELTABLE, RecipeCategory.MISC, ModItems.VERDANITE_INGOT, 0.25f, 200, "verdanite_ingot");
                offerBlasting(VERDANITE_SMELTABLE, RecipeCategory.MISC, ModItems.VERDANITE_INGOT, 0.25f, 100, "verdanite_ingot");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.HEARTWOOD_CHUNK, RecipeCategory.DECORATIONS, ModBlocks.HEARTWOOD_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.VERDANITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.VERDANITE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.MYSTITE_COAL, RecipeCategory.DECORATIONS, ModBlocks.MYSTITE_BLOCK);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_APPLE)
                        .pattern("III")
                        .pattern("IAI")
                        .pattern("III")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('A', Items.APPLE)
                        .criterion(hasItem(ModItems.VERDANITE_APPLE), conditionsFromItem(ModItems.VERDANITE_APPLE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModBlocks.CONVERTER_BLOCK)
                        .pattern("SSS")
                        .pattern("SBS")
                        .pattern("SSS")
                        .input('B', ModBlocks.VERDANITE_BLOCK)
                        .input('S', Items.STONE)
                        .criterion(hasItem(ModBlocks.CONVERTER_BLOCK), conditionsFromItem(ModBlocks.CONVERTER_BLOCK))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_CHISEL)
                        .pattern("  I")
                        .pattern(" S ")
                        .pattern("S  ")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_CHISEL), conditionsFromItem(ModItems.VERDANITE_CHISEL))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_SWORD)
                        .pattern("I")
                        .pattern("I")
                        .pattern("S")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_SWORD), conditionsFromItem(ModItems.VERDANITE_SWORD))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_PICKAXE)
                        .pattern("III")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_PICKAXE), conditionsFromItem(ModItems.VERDANITE_PICKAXE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_AXE)
                        .pattern(" II")
                        .pattern(" SI")
                        .pattern(" S ")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_AXE), conditionsFromItem(ModItems.VERDANITE_AXE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_SHOVEL)
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_SHOVEL), conditionsFromItem(ModItems.VERDANITE_SHOVEL))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.VERDANITE_HOE)
                        .pattern("II")
                        .pattern("S ")
                        .pattern("S ")
                        .input('I', ModItems.VERDANITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.VERDANITE_HOE), conditionsFromItem(ModItems.VERDANITE_HOE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.MISC, ModItems.MYSTITE_HAMMER)
                        .pattern("BBB")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.MYSTITE_HAMMER), conditionsFromItem(ModItems.MYSTITE_HAMMER))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MYSTITE_BOW)
                        .pattern(" BS")
                        .pattern("B S")
                        .pattern(" BS")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .input('S', Items.STRING)
                        .criterion(hasItem(ModItems.MYSTITE_BOW), conditionsFromItem(ModItems.MYSTITE_BOW))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MYSTITE_HELMET)
                        .pattern("BBB")
                        .pattern("B B")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .criterion(hasItem(ModItems.MYSTITE_HELMET), conditionsFromItem(ModItems.MYSTITE_HELMET))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MYSTITE_CHESTPLATE)
                        .pattern("B B")
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .criterion(hasItem(ModItems.MYSTITE_CHESTPLATE), conditionsFromItem(ModItems.MYSTITE_CHESTPLATE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MYSTITE_LEGGINGS)
                        .pattern("BBB")
                        .pattern("B B")
                        .pattern("B B")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .criterion(hasItem(ModItems.MYSTITE_LEGGINGS), conditionsFromItem(ModItems.MYSTITE_LEGGINGS))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.COMBAT, ModItems.MYSTITE_BOOTS)
                        .pattern("B B")
                        .pattern("B B")
                        .input('B', ModBlocks.MYSTITE_BLOCK)
                        .criterion(hasItem(ModItems.MYSTITE_BOOTS), conditionsFromItem(ModItems.MYSTITE_BOOTS))
                        .offerTo(recipeExporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEARTWOOD_SLAB, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_SLAB), conditionsFromItem(ModBlocks.HEARTWOOD_SLAB))
                        .offerTo(recipeExporter);
                createStairsRecipe(ModBlocks.HEARTWOOD_STAIRS, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_STAIRS), conditionsFromItem(ModBlocks.HEARTWOOD_STAIRS))
                        .offerTo(recipeExporter);
                createPressurePlateRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEARTWOOD_PRESSURE_PLATE, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_PRESSURE_PLATE), conditionsFromItem(ModBlocks.HEARTWOOD_PRESSURE_PLATE))
                        .offerTo(recipeExporter);
                createFenceRecipe(ModBlocks.HEARTWOOD_FENCE, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_FENCE), conditionsFromItem(ModBlocks.HEARTWOOD_FENCE))
                        .offerTo(recipeExporter);
                createFenceGateRecipe(ModBlocks.HEARTWOOD_FENCE_GATE, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_FENCE_GATE), conditionsFromItem(ModBlocks.HEARTWOOD_FENCE_GATE))
                        .offerTo(recipeExporter);
                getWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEARTWOOD_WALL, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_WALL), conditionsFromItem(ModBlocks.HEARTWOOD_WALL))
                        .offerTo(recipeExporter);
                createDoorRecipe(ModBlocks.HEARTWOOD_DOOR, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_DOOR), conditionsFromItem(ModBlocks.HEARTWOOD_DOOR))
                        .offerTo(recipeExporter);
                createTrapdoorRecipe(ModBlocks.HEARTWOOD_TRAPDOOR, Ingredient.ofItems(ModItems.HEARTWOOD_CHUNK))
                        .criterion(hasItem(ModBlocks.HEARTWOOD_TRAPDOOR), conditionsFromItem(ModBlocks.HEARTWOOD_TRAPDOOR))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Blocksmith Recipes";
    }
}
