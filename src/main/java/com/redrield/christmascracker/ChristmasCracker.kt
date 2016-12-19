/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.redrield.christmascracker

import com.redrield.christmascracker.commands.MainExecutor
import com.redrield.christmascracker.events.PlayerClickHandler
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.TreeMap

class ChristmasCracker : JavaPlugin() {

    val rewards = TreeMap<Int, ItemStack>()
    lateinit var christmasCracker: ItemStack

    override fun onEnable() {
        saveDefaultConfig()

        initItems()
        initChristmasCracker()
        initListener()
        initCommands()
    }

    fun initItems() {
        rewards.clear()
        var total = 0
        for(key in config.getConfigurationSection("rewards").getKeys(false)) {
            val mat = Material.valueOf(config.getString("rewards.$key.type"))
            val amnt = config.getInt("rewards.$key.amount")
            val dura = config.getInt("rewards.$key.durability").toShort()
            val item = ItemStack(mat, amnt, dura)
            val im = item.itemMeta
            im.displayName = ChatColor.translateAlternateColorCodes('&', config.getString("rewards.$key.name"))
            im.lore = config.getStringList("rewards.$key.lore").map { ChatColor.translateAlternateColorCodes('&', it) }
            im.isUnbreakable = config.getBoolean("rewards.$key.unbreakable")
            val chance = config.getInt("rewards.$key.chance")
            total += chance
            item.itemMeta = im
            rewards.put(total, item)
        }
    }

    private fun initCommands() {
        getCommand("christmascracker").executor = MainExecutor(this)
    }

    private fun initListener() {
        this.server.pluginManager.registerEvents(PlayerClickHandler(this), this)
    }

    private fun initChristmasCracker() {
        val mat = Material.valueOf(config.getString("christmascracker.type"))
        val dura = config.getInt("christmascracker.durability").toShort()
        christmasCracker = ItemStack(mat, 1)
        christmasCracker.durability = dura
        val im = christmasCracker.itemMeta
        im.displayName = ChatColor.translateAlternateColorCodes('&', config.getString("christmascracker.name"))
        im.lore = config.getStringList("christmascracker.lore").map { ChatColor.translateAlternateColorCodes('&', it) }
        im.isUnbreakable = config.getBoolean("christmascracker.unbreakable")
        christmasCracker.itemMeta = im
    }
}

operator fun ChatColor.plus(other: String): String {
    return this.toString() + other
}
