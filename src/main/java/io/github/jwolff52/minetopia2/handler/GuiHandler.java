package io.github.jwolff52.minetopia2.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import io.github.jwolff52.minetopia2.client.gui.inventory.GuiAlchemyChest;
import io.github.jwolff52.minetopia2.inventory.ContainerAlchemyChest;
import io.github.jwolff52.minetopia2.ref.GUIs;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (id == GUIs.ALCHEMY_CHEST.ordinal()) {
            TileEntityAlchemyChest tileEntityAlchemyChest = (TileEntityAlchemyChest) world.getTileEntity(x, y, z);
            return new ContainerAlchemyChest(entityPlayer.inventory, tileEntityAlchemyChest);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (id == GUIs.ALCHEMY_CHEST.ordinal()) {
            TileEntityAlchemyChest tileEntityAlchemyChest = (TileEntityAlchemyChest) world.getTileEntity(x, y, z);
            return new GuiAlchemyChest(entityPlayer.inventory, tileEntityAlchemyChest);
        }

        return null;
    }
}
