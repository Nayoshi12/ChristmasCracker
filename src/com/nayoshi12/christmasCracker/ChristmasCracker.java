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

    private Random random = new Random();
    private RewardManager rewardManager;
    private String prefix;
    private CCracker cCracker;
    @Override
    public void onEnable() {
        saveDefaultConfig();
        rewardManager = new RewardManager(this);
        prefix = this.getConfig().getString("prefix");
        cCracker = new CCracker(this);
        this.getCommand("christmascracker").setExecutor(new MainExecutor(this));
        this.getServer().getPluginManager().registerEvents(new PlayerClickHandler(this),this);
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
    public CCracker getcCracker(){
        return cCracker;
    }

}
