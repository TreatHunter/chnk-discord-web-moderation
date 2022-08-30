package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import org.springframework.stereotype.Service;

@Service
public class LeetCodeService {
    public LeetCodeService(){
    }

    public ChnkLeetCodeNum twoSum(ChnkLeetCodeNum chnkLeetCodeNum) {
        for (Integer i = 0; i < chnkLeetCodeNum.getNums().length; i++) {
            for (Integer j = i + 1; j < chnkLeetCodeNum.getNums().length; j++){
                if (chnkLeetCodeNum.getNums()[i] + chnkLeetCodeNum.getNums()[j] == chnkLeetCodeNum.getTarget()) {
                    chnkLeetCodeNum.setAnswer(new Integer[] {i, j});
                    return chnkLeetCodeNum;
                }
            }
        }
        return null;
    }
}
