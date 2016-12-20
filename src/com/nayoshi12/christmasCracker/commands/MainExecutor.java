package com.nayoshi12.christmasCracker.commands;

import com.nayoshi12.christmasCracker.ChristmasCracker;
import com.nayoshi12.christmasCracker.commands.subcommands.GiveItemCommand;
import com.nayoshi12.christmasCracker.commands.subcommands.PluginReloadCommand;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 12/19/2016.
 */
public class MainExecutor implements CommandExecutor{
    List<SubCommand> sub = new ArrayList<>();
    ChristmasCracker pl;
    public MainExecutor(ChristmasCracker pl){
        this.pl = pl;
        sub.add(new PluginReloadCommand(pl));
        sub.add(new GiveItemCommand(pl));
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(cmd.getName().equals("christmascracker")) {

            if(args.length != 0) {
                switch(args[0].toLowerCase()){
                    case "reload":
                        sub.get(0).execute(sender,args);
                        break;
                    case "give":
                        sub.get(1).execute(sender,args);
                        break;
                }
            } else {
                if(sender instanceof Player) {
                    sender.sendMessage(""+ ChatColor.GREEN +""+ ChatColor.STRIKETHROUGH +"-------------------------");
                    String text = (ChatColor.GREEN + "Made with love by ");

                    String name = ChatColor.GREEN + ""+ ChatColor.BOLD+"Redrield and Nayoshi";
                    ClickEvent same = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://redrield.com");
                    text += name;
                    sender.sendMessage(text);
                    sender.sendMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + "-------------------------");
                }
            }
            return true;
        }
        return false;
    }
}
