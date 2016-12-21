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
    private ChristmasCracker pl;
    private String name;

    public GiveItemCommand(ChristmasCracker pl, String name) {
        this.pl = pl;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(CommandSender cs, String[] args) {
        if (!(cs instanceof Player)) return;
//        pl.sendMessage(cs,"You got it boss");
//        Player player = (Player)cs;
//        player.getInventory().addItem(pl.getcCracker().toItemStack());
        if (cs.hasPermission("christmascracker.give")) {
            if (args.length < 3) {
                pl.sendMessage(cs, "the command format is:");
                pl.sendMessage(cs, "christmascracker give <player> <amount>");
                return;
            }
            for (int i = 0; i < args.length; i++) {
                cs.sendMessage(args[1]);
            }

            Player player = Bukkit.getPlayer(args[1]);
            if (player == null) {
                cs.sendMessage(ChatColor.RED + "That player is either not online, or doesn't exist!");
                return;
            }
            int amnt = Integer.parseInt(args[2]);
            ItemStack item = pl.getcCracker().toItemStack().clone();
            item.setAmount(amnt);
            player.getInventory().addItem(item);
            pl.sendMessage(cs, ChatColor.GREEN + "" + player.getName() + " has been given " + amnt + " christmas crackers!");
            pl.sendMessage(player, ChatColor.GREEN + "" + player.getName() + " has given you " + amnt + " christmas crackers!");
        } else {
            pl.sendMessage(cs, ChatColor.RED + "You don't have permission to use this command!");
        }
    }
}
