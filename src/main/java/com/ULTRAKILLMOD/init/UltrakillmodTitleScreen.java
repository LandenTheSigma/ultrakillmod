package com.ULTRAKILLMOD.init;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;

public class UltrakillmodTitleScreen extends Screen {
    public UltrakillmodTitleScreen() {
        super(Component.literal("Title Screen"));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(Button.builder(Component.literal("Continue"),
                        button -> this.minecraft.setScreen(new TitleScreen()))
                .bounds(this.width / 2 - 50, this.height-50, 100, 20)
                .build());
    }

    private final String[] lines = {
            "Villagerkind is dead.",
            "xp is fuel.          ",
            "the Nether is full.  "
    };

    private int currentLine = 0; // Index of the current line being typed
    private int charCount = 0;  // Characters revealed for the current line
    private int ticks = 0; // Timer to control typing speed
    private static final int TICKS_PER_CHAR = 1; // Adjust this to control typing speed


    @Override
    public void tick() {
        super.tick();
        ticks++;

        if (currentLine < lines.length) {
            if (charCount < lines[currentLine].length() && ticks % TICKS_PER_CHAR == 0) {
                charCount++;
            }

            if (charCount == lines[currentLine].length()) {
                if (ticks % TICKS_PER_CHAR == 0) {
                    currentLine++;
                    charCount = 0;
                }
            }
        }
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0, 0, 0);
        guiGraphics.pose().scale(1.0F, 1.0F, 1.0F);
        guiGraphics.fill(0, 0, this.width, this.height, 0xFF000000);

        int yOffset = this.height / 2 - 20;
        for (int i = 0; i <= currentLine && i < lines.length; i++) {
            String toRender = (i == currentLine) ? lines[i].substring(0, charCount) : lines[i];
            guiGraphics.drawCenteredString(
                    this.font,
                    toRender,
                    this.width / 2 - 50,
                    yOffset,
                    0xFFFFFF
            );
            yOffset += 10;
        }

        guiGraphics.pose().popPose();
    }
}
