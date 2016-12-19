package com.redrield.christmascracker.commands.subcommands

import com.redrield.christmascracker.ChristmasCracker
import com.redrield.christmascracker.commands.SubCommand
import com.redrield.christmascracker.plus
import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

class PluginReloadCommand(val plugin: ChristmasCracker) : SubCommand("reload") {

    override fun execute(cs: CommandSender, args: Array<String>) {
        if(cs.hasPermission("christmascracker.reload")) {
            plugin.reloadConfig()
            plugin.initItems()
            cs.sendMessage(ChatColor.GREEN + "The config has been reloaded!")
        }else {
            cs.sendMessage(ChatColor.RED + "You don't have permission to use this command")
        }
    }
}
