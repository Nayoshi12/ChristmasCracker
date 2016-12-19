package com.redrield.christmascracker.commands.subcommands

import com.redrield.christmascracker.ChristmasCracker
import com.redrield.christmascracker.commands.SubCommand
import com.redrield.christmascracker.plus
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

class GiveItemCommand(private val plugin: ChristmasCracker) : SubCommand("give") {
    override fun execute(cs: CommandSender, args: Array<String>) {
        if(cs.hasPermission("christmascracker.give")) {
            val player = Bukkit.getPlayer(args[0])
            if(player == null) {
                cs.sendMessage(ChatColor.RED + "That player is either not online, or doesn't exist!")
                return
            }
            val amnt = Integer.parseInt(args[1])
            val item = plugin.christmasCracker.clone()
            item.amount = amnt
            player.inventory.addItem(item)
            cs.sendMessage(ChatColor.GREEN + "${player.name} has been given $amnt christmas crackers!")
            player.sendMessage(ChatColor.GREEN + "${cs.name} has given you $amnt christmas crackers!")
        }else {
            cs.sendMessage(ChatColor.RED + "You don't have permission to use this command!")
        }
    }
}
