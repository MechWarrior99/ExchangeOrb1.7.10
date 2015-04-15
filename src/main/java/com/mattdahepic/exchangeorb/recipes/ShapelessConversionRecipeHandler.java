package com.mattdahepic.exchangeorb.recipes;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

import java.util.ArrayList;
import java.util.List;

public class ShapelessConversionRecipeHandler /*extends ShapelessOreRecipe*/ { //TODO: is this needed?
    public static void registerRecipes (ItemStack lowItem,ItemStack highItem,int lowCount,int highCount) { //TODO: fix this order
        GameRegistry.addRecipe(recipeHighToLow(highItem,lowItem,highCount,lowCount));
        GameRegistry.addRecipe(recipeLowToHigh(highItem,lowItem,highCount,lowCount));
    }
    private static IRecipe recipeHighToLow (ItemStack highItem,ItemStack lowItem,int highCount,int lowCount) {
        ItemStack output = new ItemStack(lowItem.getItem(),lowCount,lowItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemExchangeOrb,1,32767));
        for (int i = 0; i < highCount; i++) {
            input.add(highItem);
        }

        ShapelessRecipes ret = new ShapelessRecipes(output,input);
        return ret;
    }
    private static IRecipe recipeLowToHigh (ItemStack highItem,ItemStack lowItem,int highCount,int lowCount) {
        ItemStack output = new ItemStack(highItem.getItem(),highCount,highItem.getItemDamage());

        List<ItemStack> input = new ArrayList<ItemStack>();
        input.add(new ItemStack(ExchangeOrb.itemExchangeOrb,1,32767));
        for (int i = 0; i < lowCount; i++) {
            input.add(lowItem);
        }

        ShapelessRecipes ret = new ShapelessRecipes(output,input);
        return ret;
    }
}
