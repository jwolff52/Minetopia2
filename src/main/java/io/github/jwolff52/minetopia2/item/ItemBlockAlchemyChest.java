package io.github.jwolff52.minetopia2.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.jwolff52.minetopia2.ref.Messages;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemBlockAlchemyChest extends ItemBlock {

    public ItemBlockAlchemyChest(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag) {
        int metaData = itemStack.getItemDamage();

        switch(metaData) {
            case 1:
                list.add(StatCollector.translateToLocal(StatCollector.translateToLocal(Messages.Tooltips.MEDIUM)));
                break;
            case 2:
                list.add(StatCollector.translateToLocal(StatCollector.translateToLocal(Messages.Tooltips.LARGE)));
                break;
            default:
                list.add(StatCollector.translateToLocal(StatCollector.translateToLocal(Messages.Tooltips.SMALL)));
        }
    }
}
