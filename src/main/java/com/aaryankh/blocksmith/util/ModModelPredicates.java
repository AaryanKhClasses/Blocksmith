package com.aaryankh.blocksmith.util;

import com.aaryankh.blocksmith.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.MYSTITE_BOW, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) return 0.0F;
            else return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
        });
        ModelPredicateProviderRegistry.register(ModItems.MYSTITE_BOW, Identifier.ofVanilla("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
    }
}
