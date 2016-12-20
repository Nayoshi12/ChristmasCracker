package com.nayoshi12.christmasCracker.commands.subcommands;

import com.nayoshi12.christmasCracker.ChristmasCracker;
import com.nayoshi12.christmasCracker.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 12/19/2016.
 */
public class PluginReloadCommand extends SubCommand {

    private ChristmasCracker pl;
    private String name;
    public PluginReloadCommand(ChristmasCracker pl,String name){
        this.pl = pl;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(CommandSender cs, String[] args) {
        if(cs.hasPermission("christmascracker.reload")) {
            pl.reloadConfig();
            pl.sendMessage(cs,"The config has been reloaded!");
        }else {
            pl.sendMessage(cs,"You don't have permission to use this command");
        }
    }
}
