package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class ChnkLeetCodeNum {

    @Id
    @GeneratedValue
    private UUID primaryKey;

    @ManyToMany
    private Set<ChnkNumber> nums;

    @ManyToOne
    private ChnkNumber target;

    @ManyToMany
    private Set<ChnkNumber> answer;

    public UUID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(UUID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Set<ChnkNumber> getNums() {
        return nums;
    }

    public void setNums(Set<ChnkNumber> nums) {
        this.nums = nums;
    }

    public ChnkNumber getTarget() {
        return target;
    }

    public void setTarget(ChnkNumber target) {
        this.target = target;
    }

    public Set<ChnkNumber> getAnswer() {
        return answer;
    }

    public void setAnswer(Set<ChnkNumber> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ChnkLeetCodeNum{" +
                "primaryKey=" + primaryKey +
                ", nums=" + nums +
                ", target=" + target +
                ", answer=" + answer +
                '}';
    }
}
