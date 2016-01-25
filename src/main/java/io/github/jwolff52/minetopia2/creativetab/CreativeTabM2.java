package io.github.jwolff52.minetopia2.creativetab;

import io.github.jwolff52.minetopia2.ref.R;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabM2 {
    public static final CreativeTabs M2_TAB = new CreativeTabs(R.MOD_ID.toLowerCase()){
        @Override
        public Item getTabIconItem() {
            return Items.stick;
        }
    };
}
