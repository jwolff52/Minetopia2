package io.github.jwolff52.minetopia2;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import io.github.jwolff52.minetopia2.handler.ConfigurationHandler;
import io.github.jwolff52.minetopia2.init.ModBlocks;
import io.github.jwolff52.minetopia2.init.ModItems;
import io.github.jwolff52.minetopia2.init.Recipes;
import io.github.jwolff52.minetopia2.init.TileEntities;
import io.github.jwolff52.minetopia2.network.PacketHandler;
import io.github.jwolff52.minetopia2.proxy.IProxy;
import io.github.jwolff52.minetopia2.ref.R;
import io.github.jwolff52.minetopia2.util.LogHelper;

@Mod(modid=R.MOD_ID, name=R.MOD_NAME, version=R.VERSION)
public class Minetopia2 {

    @Mod.Instance
    public static Minetopia2 instance;

    @SidedProxy(clientSide=R.CLIENT_PROXY, serverSide=R.SERVER_PROXY)
    public static IProxy proxy;

    /**
     *
     * @param e
     *
     * Configs, Keybindings
     * Items and Blocks
     *
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        instance = this;

        ConfigurationHandler.init(e.getSuggestedConfigurationFile());

        PacketHandler.init();

        ModItems.init();

        ModBlocks.init();

        LogHelper.info("Pre-Initilization complete");
    }

    /**
     *
     * @param e
     *
     * GUI Handler
     * Rendering
     * Tile Entities
     * Recipes
     *
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

        TileEntities.init();

        Recipes.init();

        LogHelper.info("Initilization complete");
    }

    /**
     *
     * @param e
     *
     * Wrap things up
     *
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        LogHelper.info("Post-Initilization complete");
    }
}
