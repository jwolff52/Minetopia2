package io.github.jwolff52.minetopia2.client.gui.inventory;

import io.github.jwolff52.minetopia2.inventory.ContainerAlchemyChest;
import io.github.jwolff52.minetopia2.ref.Colors;
import io.github.jwolff52.minetopia2.ref.Names;
import io.github.jwolff52.minetopia2.ref.Textures;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiAlchemyChest extends GuiContainer {

    private TileEntityAlchemyChest tileEntityAlchemyChest;

    public GuiAlchemyChest (InventoryPlayer inventoryPlayer, TileEntityAlchemyChest tileEntity) {
        super(new ContainerAlchemyChest(inventoryPlayer, tileEntity));
        tileEntityAlchemyChest = tileEntity;

        if (this.tileEntityAlchemyChest.getState() == 0)
        {
            xSize = 230;
            ySize = 186;
        }
        else if (this.tileEntityAlchemyChest.getState() == 1)
        {
            xSize = 230;
            ySize = 240;
        }
        else if (this.tileEntityAlchemyChest.getState() == 2)
        {
            xSize = 248;
            ySize = 256;
        }
    }

    protected void drawGuiContainerForegroundLayer() {
        if (tileEntityAlchemyChest.getState() == 0 || tileEntityAlchemyChest.getState() == 1)
        {
            fontRendererObj.drawString(StatCollector.translateToLocal(tileEntityAlchemyChest.getInventoryName()), 8, 6, Integer.parseInt(Colors.PURE_WHITE, 16));
            fontRendererObj.drawString(StatCollector.translateToLocal(Names.Containers.VANILLA_INVENTORY), 35, ySize - 95 + 2, Integer.parseInt(Colors.PURE_WHITE, 16));
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        if (tileEntityAlchemyChest.getState() == 0)
        {
            this.mc.getTextureManager().bindTexture(Textures.Gui.ALCHEMICAL_CHEST_SMALL);
        }
        else if (tileEntityAlchemyChest.getState() == 1)
        {
            this.mc.getTextureManager().bindTexture(Textures.Gui.ALCHEMICAL_CHEST_MEDIUM);
        }
        else if (tileEntityAlchemyChest.getState() == 2)
        {
            this.mc.getTextureManager().bindTexture(Textures.Gui.ALCHEMICAL_CHEST_LARGE);
        }

        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}
