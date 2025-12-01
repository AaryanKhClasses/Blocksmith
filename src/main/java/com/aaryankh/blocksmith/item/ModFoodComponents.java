package com.aaryankh.blocksmith.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent VERDANITE_APPLE = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 300), 1)
            .build();
}
