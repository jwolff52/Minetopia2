package io.github.jwolff52.minetopia2.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.jwolff52.minetopia2.ref.Names;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestLarge;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestMedium;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestSmall;

public class TileEntities {

    public static void init() {
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChest.class, Names.Blocks.ALCHEMY_CHEST, "tile." + Names.Blocks.ALCHEMY_CHEST);
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestSmall.class, Names.Blocks.ALCHEMY_CHEST + "Small", "tile." + Names.Blocks.ALCHEMY_CHEST + "Small");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestMedium.class, Names.Blocks.ALCHEMY_CHEST + "Medium", "tile." + Names.Blocks.ALCHEMY_CHEST + "Medium");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestLarge.class, Names.Blocks.ALCHEMY_CHEST + "Large", "tile." + Names.Blocks.ALCHEMY_CHEST + "Large");
    }
}
