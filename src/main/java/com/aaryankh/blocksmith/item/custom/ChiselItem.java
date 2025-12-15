package com.aaryankh.blocksmith.item.custom;

import com.aaryankh.blocksmith.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;
import java.util.function.Consumer;

public class ChiselItem extends Item {
    public static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.DIAMOND_BLOCK, ModBlocks.VERDANITE_ORE,
            Blocks.ANCIENT_DEBRIS, ModBlocks.DEEPSLATE_VERDANITE_ORE
    );

    public ChiselItem(Settings settings) { super(settings); }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CHISEL_MAP.get(clickedBlock).getDefaultState());
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()), item -> {
                    assert context.getPlayer() != null;
                    context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND);
                });
                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        if(MinecraftClient.getInstance().isShiftPressed()) textConsumer.accept(Text.translatable("tooltip.blocksmith.chisel.shift_down"));
        else textConsumer.accept(Text.translatable("tooltip.blocksmith.chisel"));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
