package com.redrield.christmascracker.commands

import org.bukkit.command.CommandSender


abstract class SubCommand(val name: String) {

    abstract fun execute(cs: CommandSender, args: Array<String>)
}
