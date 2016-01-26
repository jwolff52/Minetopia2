package io.github.jwolff52.minetopia2.ref;

import io.github.jwolff52.minetopia2.util.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

/**
 * Texture specific references used throughout the code.
 */
public class Textures {
    public static final String RESOURCE_PREFIX = R.MOD_ID.toLowerCase() + ":";

    public static final class Gui {
        protected static final String GUI_TEXTURE_LOCATION = "textures/gui/";
        public static final ResourceLocation ALCHEMICAL_CHEST_SMALL = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "alchemicalChest_small.png");
        public static final ResourceLocation ALCHEMICAL_CHEST_MEDIUM = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "alchemicalChest_medium.png");
        public static final ResourceLocation ALCHEMICAL_CHEST_LARGE = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "alchemicalChest_large.png");
    }

    public static final class Model {
        private static final String MODEL_TEXTURE_LOCATION = "textures/models/";
        public static final ResourceLocation ALCHEMICAL_CHEST_SMALL = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "alchemicalChest_small.png");
        public static final ResourceLocation ALCHEMICAL_CHEST_MEDIUM = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "alchemicalChest_medium.png");
        public static final ResourceLocation ALCHEMICAL_CHEST_LARGE = ResourceLocationHelper.getResourceLocation(MODEL_TEXTURE_LOCATION + "alchemicalChest_large.png");
    }
}
