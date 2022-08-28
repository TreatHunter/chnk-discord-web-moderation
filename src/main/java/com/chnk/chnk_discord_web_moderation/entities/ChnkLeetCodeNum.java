package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ChnkLeetCodeNum {

    @Id
    @GeneratedValue
    private UUID primaryKey;

    private Integer[] nums;

    private int target;

    private Integer[] answer;

    public UUID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UUID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public Integer[] getAnswer() {
        return answer;
    }

    public void setAnswer(Integer[] answer) {
        this.answer = answer;
    }
}
