/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.redrield.christmascracker.commands

import com.redrield.christmascracker.ChristmasCracker
import com.redrield.christmascracker.commands.subcommands.GiveItemCommand
import com.redrield.christmascracker.commands.subcommands.PluginReloadCommand
import com.redrield.christmascracker.plus
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.ArrayList

class MainExecutor(val plugin: ChristmasCracker) : CommandExecutor {

    val subCommands = ArrayList<SubCommand>()

    init {
        subCommands.add(PluginReloadCommand(plugin))
        subCommands.add(GiveItemCommand(plugin))
    }

    override fun onCommand(cs: CommandSender, cmd: Command, label: String, args: Array<String>): Boolean {
        if(cmd.name.equals("christmascracker", true)) {

                if(args.isNotEmpty()) {
                    when(args[0].decapitalize()) {
                        "reload" -> {
                            subCommands.filter { it.name == "reload" }.single().execute(cs, args)
                        }
                        "give" -> {
                            subCommands.filter { it.name == "give" }.single().execute(cs, args.sliceArray(1..args.size-1))
                        }
                    }
                } else {
                    if(cs is Player) {
                        cs.sendMessage("${ChatColor.GREEN}${ChatColor.STRIKETHROUGH}-------------------------")
                        val text = TextComponent(ChatColor.GREEN + "Made with love by ")
                        val name = TextComponent("${ChatColor.GREEN}${ChatColor.BOLD}Redrield")
                        name.clickEvent = ClickEvent(ClickEvent.Action.OPEN_URL, "https://redrield.com")
                        text.addExtra(name)
                        cs.spigot().sendMessage(text)
                        cs.sendMessage("${ChatColor.GREEN}${ChatColor.STRIKETHROUGH}-------------------------")
                    }
                }
            return true
        }
        return false
    }
}
