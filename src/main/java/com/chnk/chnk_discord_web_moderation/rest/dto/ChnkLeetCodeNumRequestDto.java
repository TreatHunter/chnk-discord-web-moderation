package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

import java.util.Set;

public class ChnkLeetCodeNumRequestDto {
    private Set<ChnkNumber> nums;

    private ChnkNumber target;

    public Set<ChnkNumber> getNums() {
        return nums;
    }

    public void setNums(Set<ChnkNumber> nums) {
        this.nums = nums;
    }

    public ChnkNumber getTarget() {
        return target;
    }

    public void setTarget(ChnkNumber target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "ChnkLeetCodeNumRequestDto{" +
                "nums=" + nums +
                ", target=" + target +
                '}';
    }
}
