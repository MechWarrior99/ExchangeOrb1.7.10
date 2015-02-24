package com.mattdahepic.exchangeorb.config;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;


import java.util.Set;

public class ExchangeOrbConfigFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecaftInstance) {}
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass () {
        return ExchangeOrbGuiConfigFactory.class;
    }
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}
