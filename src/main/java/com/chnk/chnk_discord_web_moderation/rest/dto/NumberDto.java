package com.chnk.chnk_discord_web_moderation.rest.dto;

public class NumberDto {
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberDto{" +
                "number=" + number +
                '}';
    }
}
