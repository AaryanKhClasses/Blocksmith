package com.aaryankh.blocksmith;

import com.aaryankh.blocksmith.block.ModBlocks;
import com.aaryankh.blocksmith.block.entity.ModBlockEntities;
import com.aaryankh.blocksmith.block.entity.renderer.PedestalBlockEntityRenderer;
import com.aaryankh.blocksmith.screen.ModScreenHandlers;
import com.aaryankh.blocksmith.screen.custom.ConverterBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class BlocksmithClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.HEARTWOOD_DOOR, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.HEARTWOOD_TRAPDOOR, BlockRenderLayer.CUTOUT);
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.CONVERTER_BLOCK_SCREEN_HANDLER, ConverterBlockScreen::new);
    }
}
