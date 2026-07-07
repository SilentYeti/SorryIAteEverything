package com.yetuh.sorryiateeverything;

import com.mojang.datafixers.Products;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class AddItemModifier extends LootModifier {

    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> {
        Products.P3<RecordCodecBuilder.Mu<AddItemModifier>, LootItemCondition[], Integer, Item> builder =
                codecStart(inst).and(
                        BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item)
                );
        return builder.apply(inst, (conditions, priority, item) -> new AddItemModifier(conditions, priority, item));
    });

    private final Item item;

    // LootModifier's codecStart() bundles both conditions and priority, so codec() and
    // the constructor must accept priority too - it can't be dropped to a plain P2.
    public AddItemModifier(LootItemCondition[] conditionsIn, int priority, Item item) {
        super(conditionsIn, priority);
        this.item = item;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(this.item));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}