package com.mattdahepic.exchangeorb;

import com.mattdahepic.exchangeorb.recipes.RecipeConversions;
import com.mattdahepic.exchangeorb.recipes.RecipeExchangeOrb;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void registerRenderers() {

    }
    public void registerTiles() {}
    public void registerBlocksItems() {
        //item
        GameRegistry.registerItem(ExchangeOrb.itemExchangeOrb, "exchangeOrb");
    }
    public void registerRecipes() {
        //orb
        RecipeExchangeOrb.registerRecipe();
        //conversions
        RecipeConversions.registerRecipes();
    }
}
