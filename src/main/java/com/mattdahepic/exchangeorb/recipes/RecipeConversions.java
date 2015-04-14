package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.config.Config;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeConversions {
    public static void registerRecipes  () {
        /*
        How to set up a recipe, by matt, for matt:

        GameRegistry.addRecipe(ShapelessConversionRecipeHandler.recipeHighToLow());

        High Item = item worth more value
        Low Item = item worth less value

        High Count = Config.lowPerXHigh
        Low Count = Config.xHigh;
         */
        ItemStack coal = new ItemStack(Items.coal,1,0);
        ItemStack charcoal = new ItemStack(Items.coal,1,1);
        ShapelessConversionRecipeHandler.registerRecipes(coal,charcoal,Config.charcoalPerXCoal,Config.xCoal);
        ItemStack diamond = new ItemStack(Items.diamond,1,0);
        ItemStack emerald = new ItemStack(Items.emerald,1,0);
        ShapelessConversionRecipeHandler.registerRecipes(emerald,diamond,Config.diamondsPerXEmeralds,Config.xEmeralds);
        ItemStack gold = new ItemStack(Items.gold_ingot,1,0);
        ShapelessConversionRecipeHandler.registerRecipes(diamond,gold,Config.goldPerXDiamonds,Config.xDiamonds);
        ItemStack lapis = new ItemStack(Items.dye,1,4);
        ShapelessConversionRecipeHandler.registerRecipes(lapis,gold,Config.goldPerXLapis,Config.xLapis);
        ItemStack iron = new ItemStack(Items.iron_ingot,1,0);
        ShapelessConversionRecipeHandler.registerRecipes(gold,iron,Config.ironPerXGold,Config.xGold);
        ItemStack redstone = new ItemStack(Items.redstone,1,0);
        ShapelessConversionRecipeHandler.registerRecipes(redstone,iron,Config.ironPerXRedstone,Config.xRedstone);
    }
}
