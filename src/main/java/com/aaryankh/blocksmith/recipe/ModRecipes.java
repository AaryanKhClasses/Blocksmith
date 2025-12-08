package com.aaryankh.blocksmith.recipe;

import com.aaryankh.blocksmith.Blocksmith;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<ConverterBlockRecipe> CONVERTER_BLOCK_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Blocksmith.MOD_ID, "converter_block"), new ConverterBlockRecipe.Serializer()
    );

    public static final RecipeType<ConverterBlockRecipe> CONVERTER_BLOCK_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Blocksmith.MOD_ID, "converter_block"), new RecipeType<ConverterBlockRecipe>() {
                @Override
                public String toString() {
                    return "converter_block";
                }
            }
    );

    public static void registerRecipes() {
        Blocksmith.LOGGER.info("Registering Mod Recipes for " + Blocksmith.MOD_ID);
    }
}
