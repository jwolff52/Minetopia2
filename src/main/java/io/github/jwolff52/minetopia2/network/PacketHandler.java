package io.github.jwolff52.minetopia2.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import io.github.jwolff52.minetopia2.network.messages.MessageTileEntityM2;
import io.github.jwolff52.minetopia2.ref.R;

public class PacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(R.MOD_ID.toLowerCase());

    public static void init() {
        INSTANCE.registerMessage(MessageTileEntityM2.class, MessageTileEntityM2.class, 0, Side.CLIENT);
    }
}
