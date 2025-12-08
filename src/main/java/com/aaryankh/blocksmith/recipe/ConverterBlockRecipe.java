package com.aaryankh.blocksmith.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record ConverterBlockRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ConverterBlockRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ConverterBlockRecipeInput input, World world) {
        if(world.isClient()) return false;
        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(ConverterBlockRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CONVERTER_BLOCK_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CONVERTER_BLOCK_TYPE;
    }

    public static class Serializer implements RecipeSerializer<ConverterBlockRecipe> {
        public static final MapCodec<ConverterBlockRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(ConverterBlockRecipe::inputItem),
            ItemStack.CODEC.fieldOf("result").forGetter(ConverterBlockRecipe::output)
        ).apply(inst, ConverterBlockRecipe::new));

        public static final PacketCodec<RegistryByteBuf, ConverterBlockRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC, ConverterBlockRecipe::inputItem,
                ItemStack.PACKET_CODEC, ConverterBlockRecipe::output,
                ConverterBlockRecipe::new
        );

        @Override
        public MapCodec<ConverterBlockRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ConverterBlockRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
