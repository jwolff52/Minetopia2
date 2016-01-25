package io.github.jwolff52.minetopia2.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.jwolff52.minetopia2.ref.N;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChest;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestLarge;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestMedium;
import io.github.jwolff52.minetopia2.tileentity.TileEntityAlchemyChestSmall;

public class TileEntities {

    public static void init() {
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChest.class, N.Blocks.ALCHEMY_CHEST, "tile." + N.Blocks.ALCHEMY_CHEST);
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestSmall.class, N.Blocks.ALCHEMY_CHEST + "Small", "tile." + N.Blocks.ALCHEMY_CHEST + "Small");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestMedium.class, N.Blocks.ALCHEMY_CHEST + "Medium", "tile." + N.Blocks.ALCHEMY_CHEST + "Medium");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityAlchemyChestLarge.class, N.Blocks.ALCHEMY_CHEST + "Large", "tile." + N.Blocks.ALCHEMY_CHEST + "Large");
    }
}
