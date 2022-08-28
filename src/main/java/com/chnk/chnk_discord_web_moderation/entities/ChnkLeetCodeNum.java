package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "chnk_leet_code_num")
@Entity
public class ChnkLeetCodeNum {

    @Id
    @GeneratedValue
    private UUID primaryKey;

    private int[] nums;


    public UUID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UUID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }
}
