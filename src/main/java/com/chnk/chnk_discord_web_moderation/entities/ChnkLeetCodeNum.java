package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class ChnkLeetCodeNum {

    @Id
    @GeneratedValue
    private UUID primaryKey;

    @OneToMany(mappedBy = "chnkLeetCodeNum")
    private List<ChnkNumber> nums = new ArrayList<>();

    private Integer target;

    @OneToMany(mappedBy = "chnkLeetCodeNum")
    private List<ChnkAnswer> answer = new ArrayList<>();

    public UUID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UUID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public List<ChnkNumber> getNums() {
        return nums;
    }

    public void setNums(List<ChnkNumber> nums) {
        this.nums = nums;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public List<ChnkAnswer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<ChnkAnswer> answer) {
        this.answer = answer;
    }
}
