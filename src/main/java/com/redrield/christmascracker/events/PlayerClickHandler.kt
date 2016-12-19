package com.redrield.christmascracker.events

import com.redrield.christmascracker.ChristmasCracker
import org.bukkit.Color
import org.bukkit.FireworkEffect
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractAtEntityEvent
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.scheduler.BukkitRunnable
import java.util.Random

class PlayerClickHandler(private val plugin: ChristmasCracker) : Listener {

    @EventHandler
    fun onPlayerClick(e: PlayerInteractAtEntityEvent) {
        if(e.hand == EquipmentSlot.HAND) {
            val p = e.player
            val at = (e.rightClicked as? Player) ?: return
            if(p.inventory.itemInMainHand.isSimilar(plugin.christmasCracker)) {
                val rand = Random()
                val key = plugin.rewards.lastKey()
                val randP = plugin.rewards.ceilingEntry(rand.nextInt(key)+1).value
                val randAt = plugin.rewards.ceilingEntry(rand.nextInt(key)+1).value

                p.inventory.addItem(randP)
                at.inventory.addItem(randAt)
                if(p.inventory.itemInMainHand.amount > 1) {
                    p.inventory.itemInMainHand.amount -= 1
                }else {
                    p.inventory.itemInMainHand = null
                }

                val firework = p.world.spawnEntity(p.location, EntityType.FIREWORK) as Firework
                val meta = firework.fireworkMeta
                meta.addEffect(FireworkEffect.builder().trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.GREEN).withFade(Color.RED).build())

                firework.fireworkMeta = meta

                object : BukkitRunnable() {
                    override fun run() {
                        firework.detonate()
                    }
                }.runTaskLater(plugin, 2L)
            }
        }
    }
}
