package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

import java.util.Set;

public class ChnkLeetCodeNumResponseDto {
    private Set<ChnkNumber> nums;

    private ChnkNumber target;

    private Set<ChnkNumber> answer;

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

    public Set<ChnkNumber> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<ChnkNumber> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ChnkLeetCodeNumResponseDto{" +
                "nums=" + nums +
                ", target=" + target +
                ", answer=" + answer +
                '}';
    }
}
