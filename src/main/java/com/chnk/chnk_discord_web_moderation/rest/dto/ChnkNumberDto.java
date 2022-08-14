package com.chnk.chnk_discord_web_moderation.rest.dto;

public class ChnkNumberDto {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NumberDto{" +
                "number=" + value +
                '}';
    }
}
