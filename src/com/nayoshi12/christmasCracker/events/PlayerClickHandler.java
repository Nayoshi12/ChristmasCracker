package com.nayoshi12.christmasCracker.events;

import com.nayoshi12.christmasCracker.ChristmasCracker;
import com.nayoshi12.christmasCracker.Reward;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.List;
import java.util.Random;

/**
 * Created by Matthew on 12/19/2016.
 */
public class PlayerClickHandler implements Listener {
    ChristmasCracker pl;


    public PlayerClickHandler(ChristmasCracker pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractAtEntityEvent e) {

        if (e.getHand() == EquipmentSlot.HAND) {
            if (!(e.getRightClicked() instanceof Player)) return;
            Player player = e.getPlayer();
            Player at = (Player) e.getRightClicked();
            if ((!pl.getcCracker().toItemStack().isSimilar(player.getInventory().getItemInMainHand()))||
                    (!player.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equalsIgnoreCase(pl.getcCracker().getLore().get(0))))
                return;
            pl.getServer().getPluginManager().callEvent(new OpenCrackerEvent(at,player));
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.isCancelled())
            return;
        if(e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
            if(e.getDamage() <= 7 && e.getDamage() >= 4){
                e.setCancelled(true);
            }
        }


    }
    @EventHandler
    public void openCracker(OpenCrackerEvent event){
        Player player = event.getPlayerFrom();
        Player at = event.getPlayerTarget();
        if (player.getInventory().getItemInMainHand().getAmount() > 1) {
            int d = player.getInventory().getItemInMainHand().getAmount();
            player.getInventory().getItemInMainHand().setAmount(d - 1);
        } else {
            player.getInventory().setItemInMainHand(null);
        }
        pl.getRewardManager().getRandomReward().giveReward(player);
        pl.getRewardManager().getRandomReward().giveReward(at);
        pl.sendMessage(player,"You have shared Christmas Cracker with "+ ChatColor.GOLD + "" + at.getName() + ChatColor.GREEN + "!");
        pl.sendMessage(at,ChatColor.GOLD + player.getName() + ChatColor.GREEN + " has shared Christmas Cracker with you! :D");
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(FireworkEffect.builder().trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.GREEN).withFade(Color.RED).build());
        firework.setFireworkMeta(meta);
        Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
            @Override
            public void run() {
                firework.detonate();

            }
        }, 3L);

    }

}
