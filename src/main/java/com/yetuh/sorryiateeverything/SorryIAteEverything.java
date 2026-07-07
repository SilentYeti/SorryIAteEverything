package com.yetuh.sorryiateeverything;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(SorryIAteEverything.MODID)
public class SorryIAteEverything {
    public static final String MODID = "sorryiateeverything";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MEATS_TAB = CREATIVE_MODE_TABS.register("meats", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.sorryiateeverything"))
            .icon(() -> MeatItems.COOKED_MIXED_SKEWER.get().getDefaultInstance())
            .displayItems((parameters, output) -> MeatItems.ALL_MEATS.forEach(meat -> output.accept(meat.get())))
            .build());

    public SorryIAteEverything(IEventBus modEventBus, ModContainer modContainer) {
        ModLootModifiers.register(modEventBus);
        MeatItems.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
