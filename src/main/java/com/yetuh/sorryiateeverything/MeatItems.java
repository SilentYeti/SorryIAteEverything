package com.yetuh.sorryiateeverything;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Meat items dropped by vanilla passive mobs that don't already yield a meat item in
// vanilla (cow/mooshroom/pig/sheep/chicken/rabbit/cod/salmon/pufferfish/tropical fish
// are skipped - they already drop their own meat). Wired up to their mobs via the
// per-entity loot modifier jsons in data/sorryiateeverything/loot_modifiers.
//
// Every raw meat carries a small (30%) Hunger risk on eating, same as vanilla raw
// chicken - cooking removes the risk and grants a mob-themed buff instead (see the
// per-item COOKED_* entries below). The "golem" meats (copper/iron/snow) aren't real
// meat, so their cooked form still gives a joke debuff instead of a buff.
public class MeatItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SorryIAteEverything.MODID);

    private static final List<DeferredItem<Item>> ALL = new ArrayList<>();
    public static final List<DeferredItem<Item>> ALL_MEATS = Collections.unmodifiableList(ALL);

    private static final Consumable RAW_RISK = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F))
            .build();

    public static final DeferredItem<Item> STRIDER_MEAT = registerMeat("strider_meat", 4, 0.4f);
    public static final DeferredItem<Item> BAT_WINGS = registerMeat("bat_wings", 1, 0.1f);
    public static final DeferredItem<Item> ALLAY_FILLET = registerMeat("allay_fillet", 3, 0.4f);
    public static final DeferredItem<Item> ARMADILLO_STEAK = registerMeat("armadillo_steak", 3, 0.3f);
    public static final DeferredItem<Item> AXOLOTL_TAIL = registerMeat("axolotl_tail", 2, 0.2f);
    public static final DeferredItem<Item> CAMEL_HUMP_MEAT = registerMeat("camel_hump_meat", 5, 0.5f);
    public static final DeferredItem<Item> SNIFFER_SNOUT = registerMeat("sniffer_snout", 3, 0.3f);
    public static final DeferredItem<Item> HAPPY_GHAST_MEAT = registerMeat("happy_ghast_meat", 6, 0.5f);
    public static final DeferredItem<Item> NAUTILUS_TENTACLE = registerMeat("nautilus_tentacle", 3, 0.3f);
    public static final DeferredItem<Item> COPPER_SHAVINGS = registerMeat("copper_shavings", 1, 0.0f);
    public static final DeferredItem<Item> IRON_SHAVINGS = registerMeat("iron_shavings", 1, 0.0f);
    public static final DeferredItem<Item> SNOW_GOLEM_SLUSH = registerMeat("snow_golem_slush", 1, 0.1f);
    public static final DeferredItem<Item> FROG_LEGS = registerMeat("frog_legs", 3, 0.4f);
    public static final DeferredItem<Item> TADPOLE_SASHIMI = registerMeat("tadpole_sashimi", 1, 0.1f);
    public static final DeferredItem<Item> TURTLE_SOUP_MEAT = registerMeat("turtle_soup_meat", 4, 0.5f);
    public static final DeferredItem<Item> PARROT_BREAST = registerMeat("parrot_breast", 2, 0.2f);
    public static final DeferredItem<Item> OCELOT_LOIN = registerMeat("ocelot_loin", 3, 0.3f);
    public static final DeferredItem<Item> CAT_MEAT = registerMeat("cat_meat", 3, 0.3f);
    public static final DeferredItem<Item> DOLPHIN_BLUBBER = registerMeat("dolphin_blubber", 4, 0.5f);
    public static final DeferredItem<Item> CALAMARI = registerMeat("calamari", 3, 0.3f);
    public static final DeferredItem<Item> GLOWING_CALAMARI = registerMeat("glowing_calamari", 3, 0.3f);
    public static final DeferredItem<Item> GOAT_CHOPS = registerMeat("goat_chops", 3, 0.3f);
    public static final DeferredItem<Item> POLAR_BEAR_MEAT = registerMeat("polar_bear_meat", 5, 0.5f);
    public static final DeferredItem<Item> WOLF_MEAT = registerMeat("wolf_meat", 3, 0.3f);
    public static final DeferredItem<Item> FOX_MEAT = registerMeat("fox_meat", 2, 0.2f);
    public static final DeferredItem<Item> BEE_THORAX = registerMeat("bee_thorax", 1, 0.1f);
    public static final DeferredItem<Item> PANDA_MEAT = registerMeat("panda_meat", 4, 0.4f);
    public static final DeferredItem<Item> MYSTERY_MEAT = registerMeat("mystery_meat", 3, 0.3f);
    public static final DeferredItem<Item> HORSE_MEAT = registerMeat("horse_meat", 4, 0.4f);
    public static final DeferredItem<Item> DONKEY_MEAT = registerMeat("donkey_meat", 3, 0.3f);
    public static final DeferredItem<Item> MULE_MEAT = registerMeat("mule_meat", 3, 0.3f);
    public static final DeferredItem<Item> LLAMA_MEAT = registerMeat("llama_meat", 3, 0.3f);
    public static final DeferredItem<Item> SPOTTED_LLAMA_MEAT = registerMeat("spotted_llama_meat", 3, 0.4f);

    // Combines any two meats from the raw_meats tag (see data/sorryiateeverything/recipe/mixed_meat_skewer.json).
    public static final DeferredItem<Item> RAW_MIXED_SKEWER = registerMeat("raw_mixed_skewer", 5, 0.4f);

    public static final DeferredItem<Item> COOKED_STRIDER_MEAT = registerCooked("cooked_strider_meat", 7, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0));
    public static final DeferredItem<Item> COOKED_BAT_WINGS = registerCooked("cooked_bat_wings", 3, 0.3f, 1.0f,
            new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0));
    public static final DeferredItem<Item> COOKED_ALLAY_FILLET = registerCooked("cooked_allay_fillet", 6, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
    public static final DeferredItem<Item> COOKED_ARMADILLO_STEAK = registerCooked("cooked_armadillo_steak", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.RESISTANCE, 200, 0));
    public static final DeferredItem<Item> COOKED_AXOLOTL_TAIL = registerCooked("cooked_axolotl_tail", 4, 0.4f, 1.0f,
            new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0));
    public static final DeferredItem<Item> COOKED_CAMEL_HUMP_MEAT = registerCooked("cooked_camel_hump_meat", 8, 0.8f, 1.0f,
            new MobEffectInstance(MobEffects.SATURATION, 20, 0));
    public static final DeferredItem<Item> COOKED_SNIFFER_SNOUT = registerCooked("cooked_sniffer_snout", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.LUCK, 600, 0));
    public static final DeferredItem<Item> COOKED_HAPPY_GHAST_MEAT = registerCooked("cooked_happy_ghast_meat", 8, 0.8f, 1.0f,
            new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0));
    public static final DeferredItem<Item> COOKED_NAUTILUS_TENTACLE = registerCooked("cooked_nautilus_tentacle", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.BREATH_OF_THE_NAUTILUS, 300, 0));
    public static final DeferredItem<Item> COOKED_COPPER_SHAVINGS = registerCooked("cooked_copper_shavings", 2, 0.1f, 1.0f,
            new MobEffectInstance(MobEffects.WEAKNESS, 200, 0));
    public static final DeferredItem<Item> COOKED_IRON_SHAVINGS = registerCooked("cooked_iron_shavings", 2, 0.1f, 1.0f,
            new MobEffectInstance(MobEffects.SLOWNESS, 200, 0));
    public static final DeferredItem<Item> COOKED_SNOW_GOLEM_SLUSH = registerCooked("cooked_snow_golem_slush", 2, 0.2f, 1.0f,
            new MobEffectInstance(MobEffects.NAUSEA, 100, 0));
    public static final DeferredItem<Item> COOKED_FROG_LEGS = registerCooked("cooked_frog_legs", 6, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.JUMP_BOOST, 300, 1));
    public static final DeferredItem<Item> COOKED_TADPOLE_SASHIMI = registerCooked("cooked_tadpole_sashimi", 3, 0.3f, 1.0f,
            new MobEffectInstance(MobEffects.SPEED, 200, 0));
    public static final DeferredItem<Item> COOKED_TURTLE_SOUP_MEAT = registerCooked("cooked_turtle_soup_meat", 7, 0.8f, 1.0f,
            new MobEffectInstance(MobEffects.RESISTANCE, 400, 0), new MobEffectInstance(MobEffects.SLOWNESS, 400, 0));
    public static final DeferredItem<Item> COOKED_PARROT_BREAST = registerCooked("cooked_parrot_breast", 4, 0.4f, 1.0f,
            new MobEffectInstance(MobEffects.HASTE, 200, 0));
    public static final DeferredItem<Item> COOKED_OCELOT_LOIN = registerCooked("cooked_ocelot_loin", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.SPEED, 200, 0));
    public static final DeferredItem<Item> COOKED_CAT_MEAT = registerCooked("cooked_cat_meat", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.LUCK, 200, 0));
    public static final DeferredItem<Item> COOKED_DOLPHIN_BLUBBER = registerCooked("cooked_dolphin_blubber", 7, 0.8f, 1.0f,
            new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 300, 0));
    public static final DeferredItem<Item> COOKED_CALAMARI = registerCooked("cooked_calamari", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.CONDUIT_POWER, 300, 0));
    public static final DeferredItem<Item> COOKED_GLOWING_CALAMARI = registerCooked("cooked_glowing_calamari", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.GLOWING, 200, 0));
    public static final DeferredItem<Item> COOKED_GOAT_CHOPS = registerCooked("cooked_goat_chops", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.STRENGTH, 200, 0));
    public static final DeferredItem<Item> COOKED_POLAR_BEAR_MEAT = registerCooked("cooked_polar_bear_meat", 8, 0.8f, 1.0f,
            new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 0));
    public static final DeferredItem<Item> COOKED_WOLF_MEAT = registerCooked("cooked_wolf_meat", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.SPEED, 200, 0));
    public static final DeferredItem<Item> COOKED_FOX_MEAT = registerCooked("cooked_fox_meat", 4, 0.4f, 1.0f,
            new MobEffectInstance(MobEffects.JUMP_BOOST, 200, 0));
    public static final DeferredItem<Item> COOKED_BEE_THORAX = registerCooked("cooked_bee_thorax", 3, 0.3f, 1.0f,
            new MobEffectInstance(MobEffects.SPEED, 200, 1));
    public static final DeferredItem<Item> COOKED_PANDA_MEAT = registerCooked("cooked_panda_meat", 7, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.SATURATION, 20, 0));
    public static final DeferredItem<Item> COOKED_MYSTERY_MEAT = registerCooked("cooked_mystery_meat", 6, 0.6f, 0.5f,
            new MobEffectInstance(MobEffects.NAUSEA, 100, 0));
    public static final DeferredItem<Item> COOKED_HORSE_MEAT = registerCooked("cooked_horse_meat", 7, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.SPEED, 300, 0));
    public static final DeferredItem<Item> COOKED_DONKEY_MEAT = registerCooked("cooked_donkey_meat", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.STRENGTH, 200, 0));
    public static final DeferredItem<Item> COOKED_MULE_MEAT = registerCooked("cooked_mule_meat", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.HASTE, 200, 0));
    public static final DeferredItem<Item> COOKED_LLAMA_MEAT = registerCooked("cooked_llama_meat", 6, 0.6f, 1.0f,
            new MobEffectInstance(MobEffects.STRENGTH, 200, 0));
    public static final DeferredItem<Item> COOKED_SPOTTED_LLAMA_MEAT = registerCooked("cooked_spotted_llama_meat", 6, 0.7f, 1.0f,
            new MobEffectInstance(MobEffects.LUCK, 300, 0));

    public static final DeferredItem<Item> COOKED_MIXED_SKEWER = registerCooked("cooked_mixed_skewer", 9, 0.9f, 1.0f,
            new MobEffectInstance(MobEffects.SATURATION, 20, 0), new MobEffectInstance(MobEffects.REGENERATION, 100, 0));

    private static DeferredItem<Item> registerMeat(String id, int nutrition, float saturationModifier) {
        DeferredItem<Item> item = ITEMS.registerSimpleItem(id, p -> p.food(
                new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationModifier).build(), RAW_RISK));
        ALL.add(item);
        return item;
    }

    private static DeferredItem<Item> registerCooked(String id, int nutrition, float saturationModifier, float probability, MobEffectInstance... effects) {
        Consumable consumable = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(effects), probability))
                .build();
        DeferredItem<Item> item = ITEMS.registerSimpleItem(id, p -> p.food(
                new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationModifier).build(), consumable));
        ALL.add(item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
