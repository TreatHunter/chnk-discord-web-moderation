package com.chnk.chnk_discord_web_moderation.rest.dto;

import com.chnk.chnk_discord_web_moderation.entities.ChnkAnswer;
import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import java.util.List;

public class ChnkLeetCodeNumDto {
    private List<ChnkNumber> nums;

    private Integer target;

    private List<ChnkAnswer> answer;

    public List<ChnkNumber> getNums() {
        return nums;
    }

    public void setNums(List<ChnkNumber> nums) {
        this.nums = nums;
    }

    public Integer getTarget() {
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

    @Override
    public String toString() {
        return "ChnkLeetCodeNumDto{" +
                "nums=" + nums +
                ", target=" + target +
                ", answer=" + answer +
                '}';
    }
}
