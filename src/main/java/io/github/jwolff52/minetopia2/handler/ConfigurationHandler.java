package io.github.jwolff52.minetopia2.handler;


import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.github.jwolff52.minetopia2.ref.R;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

    public static Configuration config;
    public static boolean testValue;

    public static void init(File configFile) {
        if(config == null) {
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    private static void loadConfig() {
        testValue = config.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example config value");

        if(config.hasChanged()) {
            config.save();
        }
    }

    @SubscribeEvent()
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent e) {
        if(e.modID.equalsIgnoreCase(R.MOD_ID)) {
            loadConfig();
        }
    }
}
