package com.mattdahepic.exchangeorb.item;

import com.mattdahepic.exchangeorb.ExchangeOrb;
import com.mattdahepic.exchangeorb.config.Config;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemExchangeOrb extends Item {
    public ItemExchangeOrb () {
        super();
        this.setUnlocalizedName("exchangeOrb");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        if(Config.orbHasDurability && Config.orbDurability > 1) {
            this.setMaxDamage(Config.orbDurability-1);
        }
        //this.setContainerItem(this);
        //TODO: creative tabs
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon("exchangeorb:exchangeOrb");
    }
    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {
        return false;
    }
    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        if(isDamageable()) {
            System.out.println("input stack damage is: " + stack.getItemDamage() + " and output damage is: " + stack.getItemDamage()+1);
            return new ItemStack(stack.getItem(),1,stack.getItemDamage()+1);
        } else {
            return stack;
        }
    }
}
