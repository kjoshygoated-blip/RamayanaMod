package com.kartik.ramayana;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RamayanaMod.MOD_ID);
    public static final Supplier<CreativeModeTab> RAMAYANA_TAB = TABS.register("ramayana_tab",
        () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.ramayana"))
            .icon(() -> new ItemStack(ModItems.KODANDA_BOW.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.KODANDA_BOW.get());
                output.accept(ModItems.BRAHMASTRA_ARROW.get());
                output.accept(ModItems.AGNEYASTRA_ARROW.get());
                output.accept(ModItems.VARUNASTRA_ARROW.get());
                output.accept(ModItems.VAYAVYASTRA_ARROW.get());
                output.accept(ModItems.ARROW_DEFENDER.get());
            }).build());
    public static void register(IEventBus bus) { TABS.register(bus); }
}
