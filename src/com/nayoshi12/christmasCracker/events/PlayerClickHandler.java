package com.nayoshi12.christmasCracker.events;

import com.nayoshi12.christmasCracker.ChristmasCracker;
import com.nayoshi12.christmasCracker.Reward;
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
            Player p = e.getPlayer();
            e.getPlayer().sendMessage(e.getHand() + "");
            if (!(e.getRightClicked() instanceof Player)) return;
            Player player = e.getPlayer();
            Player at = (Player) e.getRightClicked();
            pl.sendMessage(e.getPlayer(), "You clicked on " + at.getName() + "!");
            pl.sendMessage(at, "You were clicked by " + e.getPlayer().getName() + "!");
            if(!pl.getcCracker().toItemStack().isSimilar(player.getInventory().getItemInMainHand())) return;
            pl.sendMessage(e.getPlayer(), pl.getcCracker().toItemStack().isSimilar(player.getInventory().getItemInMainHand()) + "");
            List<Reward> rewards = pl.getRewardManager().getAllRewards();
//            int randomB = pl.getRandom().nextInt(rewards.size()+1);
//            int randomA = pl.getRandom().nextInt(rewards.size());
//
//            pl.sendMessage(player, randomNumber() + "");
//            List<Reward> a1 = pl.getRewardManager().getRewards(randomNumber());
//            List<Reward> a2 = pl.getRewardManager().getRewards(randomNumber());
//            a1.get(pl.getRandom().nextInt(a1.size())).giveReward(player);
//            a2.get(pl.getRandom().nextInt(a2.size())).giveReward(at);
            rewards.get(pl.getRandom().nextInt(rewards.size())).giveReward(player);
            rewards.get(pl.getRandom().nextInt(rewards.size())).giveReward(at);
            if (p.getInventory().getItemInMainHand().getAmount() > 1) {
                int d = p.getInventory().getItemInMainHand().getAmount();
                p.getInventory().getItemInMainHand().setAmount(d - 1);
            } else {
                p.getInventory().setItemInMainHand(null);
            }
            Firework firework = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
            FireworkMeta meta = firework.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder().trail(false).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.GREEN).withFade(Color.RED).build());
            e.getPlayer().sendMessage("6");
            firework.setFireworkMeta(meta);
            Bukkit.getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                @Override
                public void run() {
                    firework.detonate();
                }
            }, 3L);

        }
    }

    private int randomNumber() {
        double meth = Math.floor(10 * pl.getRandom().nextDouble());
        int mee = (int) meth;
        mee *= 10;
        return mee;
    }
}
