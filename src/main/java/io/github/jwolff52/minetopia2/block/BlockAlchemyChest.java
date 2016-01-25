package io.github.jwolff52.minetopia2.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.github.jwolff52.minetopia2.Minetopia2;
import io.github.jwolff52.minetopia2.ref.GUIs;
import io.github.jwolff52.minetopia2.ref.N;
import io.github.jwolff52.minetopia2.ref.RenderIds;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestLarge;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestMedium;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestSmall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

public class BlockAlchemyChest extends BlockTileEntityM2{

	public BlockAlchemyChest(){
		super(Material.wood);
        this.setHardness(2.5f);
        this.setBlockName(N.Blocks.ALCHEMY_CHEST);
        this.setBlockBounds(0.0625f, 0.0f, 0.0625f, 0.9375f, 0.875f, 0.9375f);
	}



    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
            switch(metadata) {
                case 0:
                    return new TileEntityAlchemyChestSmall();
                case 1:
                    return new TileEntityAlchemyChestMedium();
                case 2:
                    return new TileEntityAlchemyChestLarge();
                default:
                    return null;
            }
    }

    @Override
    public int damageDropped(int metaData)
    {
        return metaData;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIds.alchemyChest;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if ((player.isSneaking() && player.getCurrentEquippedItem() != null) || world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
        {
            return true;
        }
        else
        {
            if (!world.isRemote && world.getTileEntity(x, y, z) instanceof TileEntityAlchemyChest)
            {
                player.openGui(Minetopia2.instance, GUIs.ALCHEMY_CHEST.ordinal(), world, x, y, z);
            }

            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int meta = 0; meta < 3; meta++)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }
}
