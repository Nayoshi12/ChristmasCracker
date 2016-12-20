package com.nayoshi12.christmasCracker;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Matthew on 12/20/2016.
 */
public class CCracker {
    private ChristmasCracker pl;
    private ItemStack item;
    private final String name;
    private List<String> lore;
    private boolean unbreakable;
    private Material material;
    private int durability;
    public CCracker(ChristmasCracker pl){
        this.pl = pl;
        this.material = Material.valueOf(pl.getConfig().getString("christmas-cracker.type"));
        this.name = convertText(pl.getConfig().getString("christmas-cracker.name"));
        this.lore = pl.getConfig().getStringList("christmas-cracker.lore");
        this.durability = pl.getConfig().getInt("christmas-cracker.durability");
        this.unbreakable = pl.getConfig().getBoolean("christmas-cracker.unbreakable");
        item = new ItemStack(material,1,(short)durability);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setUnbreakable(unbreakable);
        item.setItemMeta(itemMeta);
    }
    private String convertText(String msg){
        return ChatColor.translateAlternateColorCodes('&',msg);
    }
    public ItemStack toItemStack(){
        return item;
    }
    public String getName(){
        return name;
    }
    public List<String> getLore(){
        return lore;
    }
}
