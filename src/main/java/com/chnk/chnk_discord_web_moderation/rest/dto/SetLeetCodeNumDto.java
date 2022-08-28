package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

public class SetLeetCodeNumDto {
    private ChnkNumber chnkNumber;
    private Integer target;

    public ChnkNumber getChnkNumber() {
        return chnkNumber;
    }

    public void setChnkNumber(ChnkNumber chnkNumber) {
        this.chnkNumber = chnkNumber;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "SetLeetCodeNumDto{" +
                "chnkNumber=" + chnkNumber +
                ", target=" + target +
                '}';
    }
}
