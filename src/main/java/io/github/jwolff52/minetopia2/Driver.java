package io.github.jwolff52.minetopia2;

import java.util.Random;
import java.util.UUID;

public class Driver {
    public static void main(String[] args) {
        int x=1000, y=2000, z=3000;
        byte orientation=45, state=30;
        String customName="blah";
        UUID ownerUUID = new UUID(new Random().nextLong(), new Random().nextLong());
        System.out.println(String.format("MessageTileEntityEE - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, ownerUUID:%s", x, y, z, orientation, state, customName, ownerUUID));
    }
}
