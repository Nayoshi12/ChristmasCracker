package com.nayoshi12.christmasCracker;

import org.bukkit.Material;

import java.util.List;

/**
 * Created by Matthew on 12/19/2016.
 */
public class Reward {
    private String name;
    private List<String> commands;
    private final String claimMsg;
    public Reward(ChristmasCracker pl,String name){
        this.name = name;
        this.commands = pl.getConfig().getStringList("rewards." + name + ".commands");
        this.claimMsg = pl.getConfig().getString("rewards."+name+".claim-msg");
    }
    public List<String> getCommands(){
        return commands;
    }
    public String getName(){
        return name;
    }
}
