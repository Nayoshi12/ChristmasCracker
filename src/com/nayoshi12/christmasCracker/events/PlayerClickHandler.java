package com.nayoshi12.christmasCracker.events;

import com.nayoshi12.christmasCracker.ChristmasCracker;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

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
            Player p = e.getPlayer();
            e.getPlayer().sendMessage(e.getHand() + "");
            if (!(e.getRightClicked() instanceof Player)) return;
            Player player = e.getPlayer();
            Player at = (Player) e.getRightClicked();
            pl.sendMessage(e.getPlayer(),"You clicked on " + at.getName() + "!");
            pl.sendMessage(at,"You were clicked by "+ e.getPlayer().getName() + "!");
            pl.sendMessage(e.getPlayer(),pl.getcCracker().toItemStack().isSimilar(player.getInventory().getItemInMainHand()) + "");
//            p.sendMessage(pl.getChristmas().toString());
//            //p.getInventory().setItemInMainHand(pl.getChristmas());
//            if (p.getInventory().getItemInMainHand().getItemMeta().getLore().get(0).equalsIgnoreCase(pl.getChristmas().getItemMeta().getLore().get(0))) {
//                e.getPlayer().sendMessage("2");
//                Random rand = pl.getRandom();
//                int key = pl.getRewards().lastKey();
//                pl.getRewards().values().forEach(item->{
//                    e.getPlayer().sendMessage(item.toString());
//                });
//
//                ItemStack randP = pl.getRewards().ceilingEntry(rand.nextInt(key) + 1).getValue();
//                ItemStack randAt = pl.getRewards().ceilingEntry(rand.nextInt(key) + 1).getValue();
//                e.getPlayer().sendMessage("3");
//                p.getInventory().addItem(randP);
//                at.getInventory().addItem(randAt);
//                if (p.getInventory().getItemInMainHand().getAmount() > 1) {
//                    int d = p.getInventory().getItemInMainHand().getAmount();
//                    p.getInventory().getItemInMainHand().setAmount(d - 1);
//                } else {
//                    p.getInventory().setItemInMainHand(null);
//                }
//                e.getPlayer().sendMessage("5");
//                Firework firework = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
//                FireworkMeta meta = firework.getFireworkMeta();
//                meta.addEffect(FireworkEffect.builder().trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.GREEN).withFade(Color.RED).build());
//                e.getPlayer().sendMessage("6");
//                firework.setFireworkMeta(meta);
//                Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
//                    @Override
//                    public void run() {
//                        firework.detonate();
//                    }
//                }, 2L);
//                e.getPlayer().sendMessage("7");
//
//
//        }

        }
    }
}
