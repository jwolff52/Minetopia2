package io.github.jwolff52.minetopia2.init;

import cpw.mods.fml.common.registry.GameRegistry;
import io.github.jwolff52.minetopia2.block.BlockAlchemyChest;
import io.github.jwolff52.minetopia2.block.BlockM2;
import io.github.jwolff52.minetopia2.block.BlockMinetopia;
import io.github.jwolff52.minetopia2.block.BlockTileEntityM2;
import io.github.jwolff52.minetopia2.item.ItemBlockAlchemyChest;
import io.github.jwolff52.minetopia2.ref.Names;
import io.github.jwolff52.minetopia2.ref.R;

@GameRegistry.ObjectHolder(R.MOD_ID)
public class ModBlocks {

    public static final BlockTileEntityM2 alchemyChest = new BlockAlchemyChest();
    public static final BlockM2 minetopiaBlock = new BlockMinetopia();

    public static void init() {
        GameRegistry.registerBlock(alchemyChest, ItemBlockAlchemyChest.class, Names.Blocks.ALCHEMY_CHEST);
        GameRegistry.registerBlock(minetopiaBlock, Names.Blocks.MINETOPIA);
    }
}
