package com.nayoshi12.christmasCracker;

import com.nayoshi12.christmasCracker.commands.MainExecutor;
import com.nayoshi12.christmasCracker.events.PlayerClickHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

/**
 * Created by Matthew on 12/19/2016.
 */
public class ChristmasCracker extends JavaPlugin {
    //    private TreeMap<Integer,ItemStack> rewards = new TreeMap<>();
//    private ItemStack christmas;
    private Random random = new Random();
    private RewardManager rewardManager;
    private String prefix;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        rewardManager = new RewardManager(this);
        prefix = this.getConfig().getString("prefix");
//        initItems();
//        initChristmasCracker();
//        initListener();
//        initCommands();
    }
    public RewardManager getRewardManager(){
        return rewardManager;
    }
    public Random getRandom() {
        return random;
    }
    public void sendMessage(CommandSender cs,String msg){
        cs.sendMessage(ChatColor.translateAlternateColorCodes('&',prefix + " " + msg));
    }
//    public void initItems(){
//        rewards.clear();
//        int total = 0;
//        for(String key:this.getConfig().getConfigurationSection("rewards").getKeys(false)){
//            Material mat = Material.valueOf(getConfig().getString("rewards."+key+".type"));
//            int amnt = this.getConfig().getInt("rewards."+ key +".amount");
//            int dura =(int) this.getConfig().get("rewards."+ key +".durability");
//            ItemStack item = new ItemStack(mat,amnt,(short)dura);
//            ItemMeta im = item.getItemMeta();
//            im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("rewards."+ key +".name")));
//            List<String> lore = this.getConfig().getStringList("rewards." + key + ".lore");
//            List<String> lore1 = new ArrayList<>();
//            for(String l:lore){
//                lore1.add(ChatColor.translateAlternateColorCodes('&',l));
//            }
//            im.setLore(lore1);
//            im.spigot().setUnbreakable(this.getConfig().getBoolean("rewards."+ key + ".unbreakable"));
//            int chance = this.getConfig().getInt("rewards.$key.chance");
//            total += chance;
//            item.setItemMeta(im);
//            rewards.put(total, item);
//        }
//    }
//    public TreeMap<Integer,ItemStack> getRewards(){
//        return rewards;
//    }

//    public ItemStack getChristmas(){
//        return christmas;
//    }
//    private void initCommands() {
//        getCommand("christmascracker").setExecutor(new MainExecutor(this));
//    }
//
//    private void initListener() {
//        this.getServer().getPluginManager().registerEvents(new PlayerClickHandler(this),this);
//    }
//
//    private void initChristmasCracker() {
//        Material mat = Material.valueOf(this.getConfig().getString("christmascracker.type"));
//        int dura = (int)this.getConfig().get("christmascracker.durability");
//        christmas = new ItemStack(mat,1,(short)dura);
//        ItemMeta im = christmas.getItemMeta();
//        im.setDisplayName(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("christmascracker.name")));
//        List<String> lore = this.getConfig().getStringList("christmascracker.lore");
//        List<String> lore1 = new ArrayList<>();
//        for(String l:lore){
//            lore1.add(ChatColor.translateAlternateColorCodes('&',l));
//        }
//        im.setLore(lore1);
//        im.spigot().setUnbreakable(this.getConfig().getBoolean("christmascracker.unbreakable"));
//        christmas.setItemMeta(im);
//    }
}
