package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.exchangeorb.item.ItemExchangeOrb;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION,guiFactory = "com.mattdahepic.exchangeorb.config.ExchangeOrbConfigFactory")
public class ExchangeOrb {
    @Mod.Instance("exchangeorb")
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "1.7.10-1.6";
    public static final String NAME = "Exchange Orb";

    @SidedProxy(clientSide = "com.mattdahepic.exchangeorb.client.ClientProxy", serverSide = "com.mattdahepic.exchangeorb.CommonProxy")
    public static CommonProxy proxy;
    //public static ClientProxy clientProxy;

    public static Configuration configFile;

    //blocks

    //item
    public static Item itemExchangeOrb;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(instance);
        Config.load(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        itemExchangeOrb = new ItemExchangeOrb();
        proxy.registerBlocksItems();
        proxy.registerRecipes();
        proxy.registerRenderers();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogManager.getLogger().info("Ready to transmute!");
    }
}
