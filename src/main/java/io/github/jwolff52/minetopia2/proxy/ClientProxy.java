package io.github.jwolff52.minetopia2.proxy;


import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import io.github.jwolff52.minetopia2.client.renderer.item.ItemRendererAlchemyChest;
import io.github.jwolff52.minetopia2.client.renderer.tileentity.TileEntityRendererAlchemyChest;
import io.github.jwolff52.minetopia2.init.ModBlocks;
import io.github.jwolff52.minetopia2.ref.RenderIds;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderingAndTextures() {
        RenderIds.alchemyChest = RenderingRegistry.getNextAvailableRenderId();

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.alchemyChest), new ItemRendererAlchemyChest());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlchemyChest.class, new TileEntityRendererAlchemyChest());
    }
}
