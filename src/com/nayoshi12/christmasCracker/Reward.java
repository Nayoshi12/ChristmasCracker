package com.nayoshi12.christmasCracker;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Matthew on 12/19/2016.
 */
public class Reward {
    private ChristmasCracker pl;
    private String name;
    private List<String> commands;
    private final String claimMsg;
    private final int chance;
    public Reward(ChristmasCracker pl,String name){
        this.pl = pl;
        this.name = name;
        this.commands = pl.getConfig().getStringList("rewards." + name + ".commands");
        this.claimMsg = pl.getConfig().getString("rewards."+name+".claim-msg");
        this.chance = pl.getConfig().getInt("rewards."+name+".chance");
    }
    public List<String> getCommands(){
        return commands;
    }
    public String getName(){
        return name;
    }
    public void giveReward(Player player){
        for (String command : commands) {
            command = format(command, player);
            pl.getServer().dispatchCommand(pl.getServer().getConsoleSender(), command);
        }
        pl.sendMessage(player, format(claimMsg, player));
    }
    public int getChance(){
        return chance;
    }
    private String format(String text, Player player) {
        text = text.replace("{player}", player.getName());
        text = ChatColor.translateAlternateColorCodes('&', text);
        return text;
    }
}
