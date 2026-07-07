package com.yetuh.sorryiateeverything;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    // Create the DeferredRegister for your specific mod ID
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("sorryiateeverything");


    public static final DeferredItem<Item> MY_CUSTOM_ITEM = ITEMS.registerSimpleItem("my_custom_item", p -> p);

    // Call this method in your main class to attach the register to the mod bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}