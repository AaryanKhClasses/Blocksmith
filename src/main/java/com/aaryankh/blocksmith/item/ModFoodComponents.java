package com.aaryankh.blocksmith.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {
    public static final ConsumableComponent VERDANITE_APPLE_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION, 300), 1)).build();

    public static final FoodComponent VERDANITE_APPLE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
}
