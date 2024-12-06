package com.ULTRAKILLMOD.init;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Items.*;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ULTRAKILLMOD.MODID);

    public static final DeferredItem<Item> COIN = ITEMS.register("coin",
            () -> new Coin(new Item.Properties()
                    .stacksTo(16)
            ));
    public static final DeferredItem<Item> REVOLVER = ITEMS.register("revolver",
            () -> new Revolver(new Item.Properties()
                    .stacksTo(1)
                    .setNoRepair()
            ));
    public static final DeferredItem<Item> SHOTGUN = ITEMS.register("shotgun",
            () -> new Shotgun(new Item.Properties()
                    .stacksTo(1)
                    .setNoRepair()
            ));
    public static final DeferredItem<Item> RAILCANNON = ITEMS.register("railcannon",
            () -> new Railcannon(new Item.Properties()
                    .stacksTo(1)
                    .setNoRepair()
            ));
    public static final DeferredItem<Item> NAILGUN = ITEMS.register("nailgun",
            () -> new Nailgun(new Item.Properties()
                    .stacksTo(1)
                    .setNoRepair()
            ));
    public static final DeferredItem<Item> ROCKET_LAUNCHER = ITEMS.register("rocket_launcher",
            () -> new RocketLauncher(new Item.Properties()
                    .stacksTo(1)
                    .setNoRepair()
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
