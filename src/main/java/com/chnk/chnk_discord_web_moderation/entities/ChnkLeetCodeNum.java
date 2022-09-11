package com.chnk.chnk_discord_web_moderation.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class ChnkLeetCodeNum {

    @Id
    @GeneratedValue
    private UUID primaryKey;

    @ManyToMany
    private List<ChnkNumber> nums;

    @ManyToOne
    private ChnkNumber target;

    @ManyToMany
    private List<ChnkNumber> answer;

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

    public ChnkNumber getTarget() {
        return target;
    }

    public void setTarget(ChnkNumber target) {
        this.target = target;
    }

    public List<ChnkNumber> getAnswer() {
        return answer;
    }

    public void setAnswer(List<ChnkNumber> answer) {
        this.answer = answer;
    }
}
