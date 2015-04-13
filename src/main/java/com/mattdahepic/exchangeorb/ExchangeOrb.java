package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.config.Config;
import com.mattdahepic.exchangeorb.item.ItemExchangeOrb;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;

@Mod(modid = ExchangeOrb.MODID, name = ExchangeOrb.NAME, version = ExchangeOrb.VERSION, dependencies = "required-after:mdecore@[v1.0-mc1.7.10,);")
public class ExchangeOrb {
    @Mod.Instance("exchangeorb")
    public static ExchangeOrb instance;

    public static final String MODID = "exchangeorb";
    public static final String VERSION = "mc1.7.10-v1.6.1";
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
