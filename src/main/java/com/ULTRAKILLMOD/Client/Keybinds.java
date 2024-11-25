package com.ULTRAKILLMOD.Client;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

public class Keybinds {
    public static final Keybinds INSTANCE = new Keybinds();

    private Keybinds() {}
    private static final String CATAGORY = "key.catagories" + ULTRAKILLMOD.MODID;

    public final KeyMapping PARRY = new KeyMapping(
            "key." + ULTRAKILLMOD.MODID + ".PARRY",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_V, -1),
            CATAGORY
    ) ;

    public final KeyMapping SLIDE = new KeyMapping(
            "key." + ULTRAKILLMOD.MODID + ".SLIDE",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_LCONTROL, -1),
            CATAGORY
    );

    public final KeyMapping CROUCH = new KeyMapping(
            "key." + ULTRAKILLMOD.MODID + ".CROUCH (keep as the key you use to crouch)",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_LSHIFT, -1),
            CATAGORY
    );

    public final KeyMapping JUMP = new KeyMapping(
            "key." + ULTRAKILLMOD.MODID + ".SUPERJUMP",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_SPACE, -1),
            CATAGORY
    );

    public final KeyMapping DASH = new KeyMapping(
            "key." + ULTRAKILLMOD.MODID + ".DASH",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_Z, -1),
            CATAGORY
    );
}
