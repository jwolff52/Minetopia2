package io.github.jwolff52.minetopia2.network.messages;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.github.jwolff52.minetopia2.tileentity.TileEntityM2;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

import java.util.UUID;

public class MessageTileEntityM2 implements IMessage, IMessageHandler<MessageTileEntityM2, IMessage> {
    public int x, y, z;
    byte orientation, state;
    public String customName;
    public UUID ownerUUID;

    public MessageTileEntityM2() {}

    public MessageTileEntityM2(TileEntityM2 tileEntityM2) {
        this.x = tileEntityM2.xCoord;
        this.y = tileEntityM2.yCoord;
        this.z = tileEntityM2.zCoord;
        this.orientation = (byte) tileEntityM2.getOrientation().ordinal();
        this.state = tileEntityM2.getState();
        this.customName = tileEntityM2.getCustomName();
        this.ownerUUID = tileEntityM2.getOwnerUUID();
    }





    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        if(buf.readBoolean()) {
            this.ownerUUID = new UUID(buf.readLong(), buf.readLong());
        } else {
            this.ownerUUID = null;
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        if (ownerUUID != null) {
            buf.writeBoolean(true);
            buf.writeLong(ownerUUID.getMostSignificantBits());
            buf.writeLong(ownerUUID.getLeastSignificantBits());
        } else {
            buf.writeBoolean(false);
        }
    }

    @Override
    public IMessage onMessage(MessageTileEntityM2 message, MessageContext ctx) {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if(tileEntity instanceof TileEntityM2) {
            ((TileEntityM2) tileEntity).setOrientation(message.orientation);
            ((TileEntityM2) tileEntity).setState(message.state);
            ((TileEntityM2) tileEntity).setCustomName(message.customName);
            ((TileEntityM2) tileEntity).setOwnerUUID(message.ownerUUID);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("MessageTileEntityM2 - x:%d, y:%d, z:%d, orientation:%d, state:%d, customName:%s, ownerUUID:%s", x, y, z, orientation, state, customName, ownerUUID);
    }
}
