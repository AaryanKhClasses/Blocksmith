package com.aaryankh.blocksmith;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.block.entity.ModBlockEntities;
import com.aaryankh.blocksmith.block.entity.renderer.PedestalBlockEntityRenderer;
import com.aaryankh.blocksmith.screen.ModScreenHandlers;
import com.aaryankh.blocksmith.screen.custom.ConverterBlockScreen;
import com.aaryankh.blocksmith.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BlocksmithClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTWOOD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTWOOD_TRAPDOOR, RenderLayer.getCutout());
        ModModelPredicates.registerModelPredicates();
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.CONVERTER_BLOCK_SCREEN_HANDLER, ConverterBlockScreen::new);
    }
}
