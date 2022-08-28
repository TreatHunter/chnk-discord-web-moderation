package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;

public class ChnkAnswerDto {
    private Integer value;

    private ChnkLeetCodeNum chnkLeetCodeNum;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ChnkLeetCodeNum getChnkLeetCodeNum() {
        return chnkLeetCodeNum;
    }

    public void setChnkLeetCodeNum(ChnkLeetCodeNum chnkLeetCodeNum) {
        this.chnkLeetCodeNum = chnkLeetCodeNum;
    }

    @Override
    public String toString() {
        return "ChnkAnswerDto{" +
                "value=" + value +
                ", chnkLeetCodeNum=" + chnkLeetCodeNum +
                '}';
    }
}
