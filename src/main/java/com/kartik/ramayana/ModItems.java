package com.kartik.ramayana;

import net.minecraft.world.item.*;
import net.minecraft.world.item.ArrowItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RamayanaMod.MOD_ID);

    // Kodanda Bow - Shree Ram's Bow
    public static final DeferredItem<Item> KODANDA_BOW = ITEMS.register("kodanda_bow",
        () -> new BowItem(new Item.Properties().durability(1000).rarity(Rarity.EPIC)));

    // Brahmastra Arrow - Blasts almost a whole chunk!
    public static final DeferredItem<Item> BRAHMASTRA_ARROW = ITEMS.register("brahmastra_arrow",
        () -> new BrahmastraArrowItem(new Item.Properties().rarity(Rarity.EPIC)));

    // Agneyastra - Fire Arrow
    public static final DeferredItem<Item> AGNEYASTRA_ARROW = ITEMS.register("agneyastra_arrow",
        () -> new DivineArrowItem(new Item.Properties().rarity(Rarity.RARE), DivineArrowItem.Type.FIRE));

    // Varunastra - Water Arrow
    public static final DeferredItem<Item> VARUNASTRA_ARROW = ITEMS.register("varunastra_arrow",
        () -> new DivineArrowItem(new Item.Properties().rarity(Rarity.RARE), DivineArrowItem.Type.WATER));

    // Vayavyastra - Wind Arrow
    public static final DeferredItem<Item> VAYAVYASTRA_ARROW = ITEMS.register("vayavyastra_arrow",
        () -> new DivineArrowItem(new Item.Properties().rarity(Rarity.RARE), DivineArrowItem.Type.WIND));

    // Arrow Defender - One arrow becomes 300!
    public static final DeferredItem<Item> ARROW_DEFENDER = ITEMS.register("arrow_defender",
        () -> new ArrowDefenderItem(new Item.Properties().durability(500).rarity(Rarity.EPIC)));

    public static void register(IEventBus bus) { ITEMS.register(bus); }
}
