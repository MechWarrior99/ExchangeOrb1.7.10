package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.exchangeorb.item.ItemExchangeOrb;
import com.mattdahepic.exchangeorb.network.DurabilitySyncPacket;
import com.mattdahepic.exchangeorb.network.PacketHandler;
import com.mattdahepic.mdecore.update.UpdateChecker;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = "required-after:mdecore@[v1.0-mc1.7.10,);")
public class ExchangeOrb {
    @Mod.Instance("exchangeorb")
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "v1.7-mc1.7.10";
    public static final String NAME = "Exchange Orb";

    @SidedProxy(clientSide = "com.mattdahepic.exchangeorb.client.ClientProxy", serverSide = "com.mattdahepic.exchangeorb.CommonProxy")
    public static CommonProxy proxy;

    public static Configuration configFile;

    //item
    public static Item itemExchangeOrb;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(instance);
        Config.load(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        PacketHandler.initPackets();
        itemExchangeOrb = new ItemExchangeOrb();
        proxy.registerBlocksItems();
        proxy.registerRecipes();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogManager.getLogger().info("Ready to transmute!");
    }
    @Mod.EventHandler
    public void loadComplete (FMLLoadCompleteEvent event) {
        UpdateChecker.updateCheck(MODID,NAME,"https://raw.githubusercontent.com/MattDahEpic/ExchangeOrb1.7.10/master/version.txt",VERSION);
    }
    @Mod.EventHandler
    public void onPlayerJoinServer (PlayerEvent.PlayerLoggedInEvent event) {
        if (!event.player.worldObj.isRemote) {
            if (event.player instanceof EntityPlayerMP) {
                IMessage message = new DurabilitySyncPacket.DurabilitySyncMessage(Config.orbHasDurability,Config.orbDurability);
                PacketHandler.net.sendTo(message,(EntityPlayerMP)event.player);
            }
        }
    }
}
