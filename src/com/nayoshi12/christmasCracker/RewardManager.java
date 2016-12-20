package com.nayoshi12.christmasCracker;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private List<List<Reward>> chancesList = new ArrayList<>();

    public RewardManager(ChristmasCracker pl){
        this.pl = pl;
        this.config = pl.getConfig();
        Set<String> rewardsStrings  = config.getConfigurationSection("rewards").getKeys(false);
        for(String rewardString:rewardsStrings){
            Reward reward = new Reward(pl,rewardString);
            rewards.add(reward);
        }
    for(int i =1;i<10;i++){
        chancesList.add(new ArrayList<>());
        for(Reward reward:rewards){
            double d = (double)reward.getChance();
            d /= 10;
            d = Math.floor(d);
            int c = (int)d;
            c *= 10;
            if((i*10)>c)
                chancesList.get(i-1).add(reward);
        }

    }

    }
    public List<Reward> getRewards(int chance){
        for(int i = 1; i<10;i++){
            if(chance <= (i*10)){
                return chancesList.get(i-1);
            }
        }
        return null;
    }
    public List<Reward> getAllRewards(){
        return rewards;
    }


}
