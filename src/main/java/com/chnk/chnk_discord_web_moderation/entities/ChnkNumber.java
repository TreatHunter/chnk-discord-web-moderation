package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ChnkNumber {
    @Id
    @GeneratedValue
    private UUID primaryKey;
    private Integer value;

    public UUID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UUID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChnkNumber{" +
                "primaryKey=" + primaryKey +
                ", value=" + value +
                '}';
    }
}