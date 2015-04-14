package com.mattdahepic.exchangeorb.network;

import com.mattdahepic.exchangeorb.config.Config;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;

public class SyncPacket implements IMessageHandler<SyncPacket.SyncMessage,IMessage> {
    @Override
    public IMessage onMessage (SyncMessage message,MessageContext ctx) {
        if (ctx.side.isClient()) {
            System.out.println("Recieved config sync packet!");
            Config.orbHasDurability = message.orbHasDurability;
            Config.orbDurability = message.orbDurability;
            Config.charcoalPerXCoal = message.charcoalPerXCoal;
            Config.xCoal = message.xCoal;
            Config.diamondsPerXEmeralds = message.diamondsPerXEmeralds;
            Config.xEmeralds = message.xEmeralds;
            Config.goldPerXDiamonds = message.goldPerXDiamonds;
            Config.xDiamonds = message.xDiamonds;
            Config.goldPerXLapis = message.goldPerXLapis;
            Config.xLapis = message.xLapis;
            Config.ironPerXGold = message.ironPerXGold;
            Config.xGold = message.xGold;
            Config.ironPerXRedstone = message.ironPerXRedstone;
            Config.xRedstone = message.xRedstone;
        } else {
            System.out.println("side not client!");
        }
        return null;
    }
    public static class SyncMessage implements IMessage {
        private boolean orbHasDurability;
        private int orbDurability;
        private int charcoalPerXCoal;
        private int xCoal;
        private int diamondsPerXEmeralds;
        private int xEmeralds;
        private int goldPerXDiamonds;
        private int xDiamonds;
        private int goldPerXLapis;
        private int xLapis;
        private int ironPerXGold;
        private int xGold;
        private int ironPerXRedstone;
        private int xRedstone;
        public SyncMessage() {}
        public SyncMessage(boolean orbHasDurability, int orbDurability, int charcoalPerXCoal, int xCoal, int diamondsPerXEmeralds, int xEmeralds, int goldPerXDiamonds, int xDiamonds, int goldPerXLapis, int xLapis, int ironPerXGold, int xGold, int ironPerXRedstone, int xRedstone) {
            this.orbHasDurability = orbHasDurability;
            this.orbDurability = orbDurability;
            this.charcoalPerXCoal = charcoalPerXCoal;
            this.xCoal = xCoal;
            this.diamondsPerXEmeralds = diamondsPerXEmeralds;
            this.xEmeralds = xEmeralds;
            this.goldPerXDiamonds = goldPerXDiamonds;
            this.xDiamonds = xDiamonds;
            this.goldPerXLapis = goldPerXLapis;
            this.xLapis = xLapis;
            this.ironPerXGold = ironPerXGold;
            this.xGold = xGold;
            this.ironPerXRedstone = ironPerXRedstone;
            this.xRedstone = xRedstone;
        }
        @Override
        public void fromBytes (ByteBuf buf) {
            this.orbHasDurability = buf.readBoolean();
            this.orbDurability = buf.readInt();
            this.charcoalPerXCoal = buf.readInt();
            this.xCoal = buf.readInt();
            this.diamondsPerXEmeralds = buf.readInt();
            this.xEmeralds = buf.readInt();
            this.goldPerXDiamonds = buf.readInt();
            this.xDiamonds = buf.readInt();
            this.goldPerXLapis = buf.readInt();
            this.xLapis = buf.readInt();
            this.ironPerXGold = buf.readInt();
            this.xGold = buf.readInt();
            this.ironPerXRedstone = buf.readInt();
            this.xRedstone = buf.readInt();
        }
        @Override
        public void toBytes (ByteBuf buf) {
            buf.writeBoolean(orbHasDurability);
            buf.writeInt(orbDurability);
            buf.writeInt(charcoalPerXCoal);
            buf.writeInt(xCoal);
            buf.writeInt(diamondsPerXEmeralds);
            buf.writeInt(xEmeralds);
            buf.writeInt(goldPerXDiamonds);
            buf.writeInt(xDiamonds);
            buf.writeInt(goldPerXLapis);
            buf.writeInt(xLapis);
            buf.writeInt(ironPerXGold);
            buf.writeInt(xGold);
            buf.writeInt(ironPerXRedstone);
            buf.writeInt(xRedstone);
        }
    }
}
