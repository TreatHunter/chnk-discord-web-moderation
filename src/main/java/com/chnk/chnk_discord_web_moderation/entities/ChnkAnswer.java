package com.chnk.chnk_discord_web_moderation.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class ChnkAnswer {
    @Id
    @GeneratedValue
    private UUID primaryKey;

    private Integer value;
    @ManyToOne
    private ChnkLeetCodeNum chnkLeetCodeNum;

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

    public ChnkLeetCodeNum getChnkLeetCodeNum() {
        return chnkLeetCodeNum;
    }

    public void setChnkLeetCodeNum(ChnkLeetCodeNum chnkLeetCodeNum) {
        this.chnkLeetCodeNum = chnkLeetCodeNum;
    }
}
