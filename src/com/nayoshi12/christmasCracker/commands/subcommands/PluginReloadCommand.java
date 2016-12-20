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

    ChristmasCracker pl;
    public PluginReloadCommand(ChristmasCracker pl){
        this.pl = pl;
    }

    @Override
    public void execute(CommandSender cs, String[] args) {
//        if(cs.hasPermission("christmascracker.reload")) {
//            pl.reloadConfig();
//            pl.initItems();
//            cs.sendMessage(ChatColor.GREEN + "The config has been reloaded!");
//        }else {
//            cs.sendMessage(ChatColor.RED + "You don't have permission to use this command");
//        }
    }
}
