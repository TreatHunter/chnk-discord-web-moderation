package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkAnswer;
import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.repositories.AnswerRepository;
import com.chnk.chnk_discord_web_moderation.repositories.LeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.NumbersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeetCodeService {

    private final LeetCodeNumRepository leetCodeNumRepository;
    private final AnswerRepository answerRepository;
    private final NumbersRepository numbersRepository;

    public LeetCodeService(LeetCodeNumRepository leetCodeNumRepository, AnswerRepository answerRepository, NumbersRepository numbersRepository) {
        this.leetCodeNumRepository = leetCodeNumRepository;
        this.answerRepository = answerRepository;
        this.numbersRepository = numbersRepository;
    }

    public ChnkLeetCodeNum twoSum(ChnkLeetCodeNum chnkLeetCodeNum) {
        for (Integer i = 0; i < chnkLeetCodeNum.getNums().size(); i++) {
            for (Integer j = i + 1; j < chnkLeetCodeNum.getNums().size(); j++){
                if (chnkLeetCodeNum.getNums().get(i).getValue() + chnkLeetCodeNum.getNums().get(j).getValue() == chnkLeetCodeNum.getTarget()) {
                    List<ChnkAnswer> chnkAnswerList = new ArrayList<>();
                    chnkAnswerList.add(new ChnkAnswer());
                    chnkAnswerList.get(0).setValue(i);
                    chnkAnswerList.add(new ChnkAnswer());
                    chnkAnswerList.get(1).setValue(j);
                    chnkLeetCodeNum.setAnswer(chnkAnswerList);
                    return chnkLeetCodeNum;
                }
            }
        }
        return null;
    }

    public ChnkLeetCodeNum saveLeetCodeNum(ChnkLeetCodeNum chnkLeetCodeNum){
        /*answerRepository.save(chnkLeetCodeNum.getAnswer().get(0));
        answerRepository.save(chnkLeetCodeNum.getAnswer().get(1));
        numbersRepository.save(chnkLeetCodeNum.getNums().get(0));
        numbersRepository.save(chnkLeetCodeNum.getNums().get(1));
        numbersRepository.save(chnkLeetCodeNum.getNums().get(2));
        numbersRepository.save(chnkLeetCodeNum.getNums().get(3));*/
        chnkLeetCodeNum = leetCodeNumRepository.save(chnkLeetCodeNum);
        return chnkLeetCodeNum;
    }
}
