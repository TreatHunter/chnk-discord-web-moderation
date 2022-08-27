package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import org.springframework.stereotype.Service;

@Service
public class LeetCodeService {
    public LeetCodeService(){
    }

    public ChnkLeetCodeNum twoSum(int[] nums, int target) {
        ChnkLeetCodeNum chnkLeetCodeNum = new ChnkLeetCodeNum();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target) {
                    chnkLeetCodeNum.setNums(new int[] {i, j});
                    return chnkLeetCodeNum;
                }
            }
        }
        return null;
    }
}
