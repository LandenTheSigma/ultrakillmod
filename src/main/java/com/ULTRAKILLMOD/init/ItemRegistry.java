package com.ULTRAKILLMOD.init;

import com.ULTRAKILLMOD.ULTRAKILLMOD;
import com.ULTRAKILLMOD.init.Items.Coin;
import com.ULTRAKILLMOD.init.Items.Revolver;
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


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
