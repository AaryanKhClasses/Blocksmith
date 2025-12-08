package com.aaryankh.blocksmith.screen;

import com.aaryankh.blocksmith.Blocksmith;
import com.aaryankh.blocksmith.screen.custom.ConverterBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ConverterBlockScreenHandler> CONVERTER_BLOCK_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Blocksmith.MOD_ID, "converter_block_screen_handler"),
                    new ExtendedScreenHandlerType<>(ConverterBlockScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        Blocksmith.LOGGER.info("Registering Screen Handlers for: " + Blocksmith.MOD_ID);
    }
}
