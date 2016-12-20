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
public class GiveItemCommand extends SubCommand {
    ChristmasCracker pl;
    public GiveItemCommand(ChristmasCracker pl){
        this.pl = pl;
    }
    @Override
    public void execute(CommandSender cs, String[] args) {
        if(cs.hasPermission("christmascracker.give")) {
            for(int i = 0; i<args.length;i++){
                cs.sendMessage(args[1]);
            }
            if(args.length<3)
                return;
            Player player = Bukkit.getPlayer(args[1]);
            if(player == null) {
                cs.sendMessage(ChatColor.RED + "That player is either not online, or doesn't exist!");
                return;
            }
            int amnt = Integer.parseInt(args[2]);
            ItemStack item = pl.getChristmas().clone();
            item.setAmount(amnt);
            player.getInventory().addItem(item);
            cs.sendMessage(ChatColor.GREEN + "" + player.getName() + " has been given "+ amnt + " christmas crackers!");
            player.sendMessage(ChatColor.GREEN + "" + player.getName() + " has given you " + amnt + " christmas crackers!");
        }else {
            cs.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
        }
    }
}
