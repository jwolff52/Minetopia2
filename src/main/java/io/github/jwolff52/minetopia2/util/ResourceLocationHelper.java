package io.github.jwolff52.minetopia2.util;

import io.github.jwolff52.minetopia2.ref.R;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper {
    public static ResourceLocation getResourceLocation(String modId, String path) {
        return new ResourceLocation(modId, path);
    }
    public static ResourceLocation getResourceLocation(String path) {
         return getResourceLocation(R.MOD_ID.toLowerCase(), path);
    }
}
