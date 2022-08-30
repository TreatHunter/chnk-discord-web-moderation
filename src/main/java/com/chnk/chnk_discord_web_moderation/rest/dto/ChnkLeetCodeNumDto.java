package com.chnk.chnk_discord_web_moderation.rest.dto;

import java.util.Arrays;

public class ChnkLeetCodeNumDto {
    private Integer[] nums;

    private Integer target;

    private Integer[] answer;

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer[] getAnswer() {
        return answer;
    }

    public void setAnswer(Integer[] answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ChnkLeetCodeNumDto{" +
                "nums=" + Arrays.toString(nums) +
                ", target=" + target +
                ", answer=" + Arrays.toString(answer) +
                '}';
    }
}
