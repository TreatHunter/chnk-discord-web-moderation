package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

import java.util.List;

public class ChnkLeetCodeNumResponseDto {
    private List<ChnkNumber> nums;

    private ChnkNumber target;

    private List<ChnkNumber> answer;

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

    public List<ChnkNumber> getAnswer() {
        return answer;
    }

    public void setAnswer(List<ChnkNumber> answer) {
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
