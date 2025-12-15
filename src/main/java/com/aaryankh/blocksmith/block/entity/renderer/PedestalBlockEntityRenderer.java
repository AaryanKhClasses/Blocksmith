package com.aaryankh.blocksmith.block.entity.renderer;

import com.aaryankh.blocksmith.block.entity.custom.PedestalBlockEntity;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity, PedestalBlockEntityRenderState> {
    private final ItemModelManager manager;

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        manager = ctx.itemModelManager();
    }

    @Override
    public void render(PedestalBlockEntityRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.translate(0.5f, 1.15f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.rotation));
        state.itemRenderState.render(matrices, queue, getLightLevel(state.blockEntityWorld, state.pos), OverlayTexture.DEFAULT_UV, 0);
        matrices.pop();
    }

    @Override
    public PedestalBlockEntityRenderState createRenderState() {
        return new PedestalBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(PedestalBlockEntity blockEntity, PedestalBlockEntityRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
        state.lightPos = blockEntity.getPos();
        state.blockEntityWorld = blockEntity.getWorld();
        state.rotation = blockEntity.getRenderingRotation();

        manager.clearAndUpdate(state.itemRenderState, blockEntity.getStack(0), ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
