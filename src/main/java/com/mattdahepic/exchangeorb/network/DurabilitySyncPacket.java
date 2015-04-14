package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.config.Config;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class DurabilitySyncPacket implements IMessageHandler<DurabilitySyncPacket.DurabilitySyncMessage,IMessage> {
    @Override
    public IMessage onMessage (DurabilitySyncMessage message,MessageContext ctx) {
        if (ctx.side.isClient()) {
            System.out.println("Durability Sync packet received!");
            Config.orbHasDurability = message.isDurable;
            Config.orbDurability = message.durability;
            System.out.println("Durability enabled == "+Config.orbHasDurability);
            System.out.println("Durability == "+Config.orbDurability);
        }
        return null;
    }
    public static class DurabilitySyncMessage implements IMessage {
        private boolean isDurable;
        private int durability;
        public DurabilitySyncMessage () {}
        public DurabilitySyncMessage (boolean isDurable,int durability) {
            this.isDurable = isDurable;
            this.durability = durability;
        }
        @Override
        public void fromBytes (ByteBuf buf) {
            this.isDurable = buf.readBoolean();
            this.durability = buf.readInt();
        }
        @Override
        public void toBytes (ByteBuf buf) {
            buf.writeBoolean(isDurable);
            buf.writeInt(durability);
        }
    }
}
