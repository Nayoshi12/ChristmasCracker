package com.nayoshi12.christmasCracker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Matthew on 12/20/2016.
 */
//TODO: Create a list for seperate chances
//FOR EXAMPLE: if they have a 50% chance to get it, if it lands on 50, then it will have rng on all of the items
//    double chanceA;
//            chanceA = Math.floor(10*pl.getRandom().nextDouble());
public class RewardManager {
    private ChristmasCracker pl;
    private FileConfiguration config;
    private List<Reward> rewards = new ArrayList<>();
    private TreeMap<Integer,Reward> chanceRewards = new TreeMap<>();

    public RewardManager(ChristmasCracker pl){
        this.pl = pl;
        this.config = pl.getConfig();
        Set<String> rewardsStrings  = config.getConfigurationSection("rewards").getKeys(false);

        for(String rewardString:rewardsStrings){
            Reward reward = new Reward(pl,rewardString);
            rewards.add(reward);
        }
        for(Reward reward:rewards){
            chanceRewards.put(reward.getChance(),reward);
        }

    }
    public Reward getRandomReward(){
        int key = chanceRewards.lastKey();
        return chanceRewards.ceilingEntry(pl.getRandom().nextInt(key)+1).getValue();
    }
    public List<Reward> getAllRewards(){
        return rewards;
    }


}
