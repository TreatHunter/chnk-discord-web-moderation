package com.chnk.chnk_discord_web_moderation.rest.dto;

import java.util.Arrays;

public class ChnkLeetCodeNumDto {
    private int[] nums;

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "ChnkLeetCodeNumDto{" +
                "nums=" + Arrays.toString(nums) +
                '}';
    }
}
