package com.nayoshi12.christmasCracker;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Matthew on 12/20/2016.
 */
public class RewardManager {
    private ChristmasCracker pl;
    private FileConfiguration config;
    private List<Reward> rewards = new ArrayList<>();
    public RewardManager(ChristmasCracker pl){
        this.pl = pl;
        this.config = pl.getConfig();
        Set<String> rewardsStrings  = config.getConfigurationSection("rewards").getKeys(false);
        for(String rewardString:rewardsStrings){
            Reward reward = new Reward(pl,rewardString);
            rewards.add(reward);
        }
    }


}
