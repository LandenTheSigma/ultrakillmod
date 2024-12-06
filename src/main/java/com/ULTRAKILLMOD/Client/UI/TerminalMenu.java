package com.ULTRAKILLMOD.Client.UI;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TerminalMenu extends Screen {
    private static final int MENU_WIDTH = 200;
    private static final int MENU_HEIGHT = 200;
    private static final int MENU_X = 100;
    private static final int MENU_Y = 10;

    public TerminalMenu(Component title) {
        super(title);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        PoseStack poseStack = guiGraphics.pose();

        // Render the menu background (semi-transparent black rectangle)
        guiGraphics.fill(MENU_X, MENU_Y, MENU_X + MENU_WIDTH, MENU_Y + MENU_HEIGHT, 0xAA000000);

        super.render(guiGraphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
