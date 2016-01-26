package io.github.jwolff52.minetopia2.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.jwolff52.minetopia2.ref.Textures;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemRendererAlchemyChest implements IItemRenderer {
    private final ModelChest modelChest;

    public ItemRendererAlchemyChest() { modelChest = new ModelChest(); }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {
            case ENTITY:
                renderAlchemyChest(0.5f, 0.5f, 0.5f, item.getItemDamage());
                break;
            case EQUIPPED:
                renderAlchemyChest(1.0f, 1.0f, 1.0f, item.getItemDamage());
                break;
            case EQUIPPED_FIRST_PERSON:
                renderAlchemyChest(1.0f, 1.0f, 1.0f, item.getItemDamage());
                break;
            case INVENTORY:
                renderAlchemyChest(0.0f, 0.075f, 0.0f, item.getItemDamage());
                break;
            default:
        }
    }

    private void renderAlchemyChest(float x, float y, float z, int metaData) {
        switch(metaData) {
            case 1:
                FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ALCHEMICAL_CHEST_MEDIUM);
                break;
            case 2:
                FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ALCHEMICAL_CHEST_LARGE);
                break;
            default:
                FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.Model.ALCHEMICAL_CHEST_SMALL);
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        modelChest.renderAll();
        GL11.glPopMatrix();
    }
}
