package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

import java.util.List;

public class ChnkLeetCodeNumRequestDto {
    private List<ChnkNumber> nums;

    private ChnkNumber target;

    public List<ChnkNumber> getNums() {
        return nums;
    }

    public void setNums(List<ChnkNumber> nums) {
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
