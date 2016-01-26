package io.github.jwolff52.minetopia2.client.renderer.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.jwolff52.minetopia2.ref.Textures;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class TileEntityRendererAlchemyChest extends TileEntitySpecialRenderer {
    private final ModelChest modelChest = new ModelChest();

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        if(tileEntity instanceof TileEntityAlchemyChest) {
            TileEntityAlchemyChest tileEntityAlchemyChest = (TileEntityAlchemyChest) tileEntity;
            ForgeDirection direction = null;

            if(tileEntityAlchemyChest.getWorldObj() != null) {
                direction = tileEntityAlchemyChest.getOrientation();
            }

            switch(tileEntityAlchemyChest.getState()) {
                case 1:
                    this.bindTexture(Textures.Model.ALCHEMICAL_CHEST_MEDIUM);
                    break;
                case 2:
                    this.bindTexture(Textures.Model.ALCHEMICAL_CHEST_LARGE);
                    break;
                default:
                    this.bindTexture(Textures.Model.ALCHEMICAL_CHEST_SMALL);
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glTranslatef((float) x, (float) y + 1.0f, (float) z + 1.0f);
            GL11.glScalef(1.0f, -1.0f, -1.0f);
            GL11.glTranslatef(0.5f, 0.5f, 0.5f);
            short angle = 0;

            if(direction != null) {
                switch (direction) {
                    case EAST:
                        angle = -90;
                        break;
                    case NORTH:
                        angle = 180;
                        break;
                    case WEST:
                        angle = 90;
                        break;
                    default:
                        angle = 0;

                }
            }

            GL11.glRotatef(angle, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(-0.5f ,-0.5f, -0.5f);
            float adjustedLidAngle = tileEntityAlchemyChest.prevLidAngle + (tileEntityAlchemyChest.lidAngle - tileEntityAlchemyChest.prevLidAngle) * tick;
            adjustedLidAngle -= 1.0f;
            adjustedLidAngle -= 1.0f + adjustedLidAngle + adjustedLidAngle;
            modelChest.chestLid.rotateAngleX = (adjustedLidAngle * (float) Math.PI / 2.0f);
            modelChest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
}
