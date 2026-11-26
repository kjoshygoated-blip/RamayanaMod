package com.kartik.ramayana;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(RamayanaMod.MOD_ID)
public class RamayanaMod {
    public static final String MOD_ID = "ramayana";
    public static final Logger LOGGER = LogUtils.getLogger();
    public RamayanaMod(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModTabs.register(modEventBus);
        LOGGER.info("JAI SHREE RAM! Ramayana Mod loaded!");
    }
}
