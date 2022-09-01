package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkLeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkNumbersRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LeetCodeService {
    private final ChnkLeetCodeNumRepository chnkLeetCodeNumRepository;
    private final ChnkNumbersRepository chnkNumbersRepository;

    public LeetCodeService(ChnkLeetCodeNumRepository chnkLeetCodeNumRepository, ChnkNumbersRepository chnkNumbersRepository) {
        this.chnkLeetCodeNumRepository = chnkLeetCodeNumRepository;
        this.chnkNumbersRepository = chnkNumbersRepository;
    }

    public ChnkLeetCodeNum twoSum(ChnkLeetCodeNum chnkLeetCodeNum) {
        Set<ChnkNumber> numberSet = new HashSet<>();
        Set<ChnkNumber> answerSet = new HashSet<>();

        for (ChnkNumber chnkNumber1 : chnkLeetCodeNum.getNums()){
            for (ChnkNumber chnkNumber2 : chnkLeetCodeNum.getNums()){
                if (chnkNumber1.getValue() + chnkNumber2.getValue() == chnkLeetCodeNum.getTarget().getValue()){

                    if (chnkNumbersRepository.getAllByValue(chnkNumber1.getValue()).size() == 0) {
                        ChnkNumber answerIntA = new ChnkNumber();
                        answerIntA.setValue(chnkNumber1.getValue());
                        chnkNumbersRepository.save(answerIntA);
                        answerSet.add(answerIntA);
                    }else{
                        answerSet.add(chnkNumbersRepository.getAllByValue(chnkNumber1.getValue()).get(0));
                    }
                    chnkLeetCodeNum.setAnswer(answerSet);


                    if (chnkNumbersRepository.getAllByValue(chnkNumber2.getValue()).size() == 0) {
                        ChnkNumber answerIntB = new ChnkNumber();
                        answerIntB.setValue(chnkNumber2.getValue());
                        chnkNumbersRepository.save(answerIntB);
                        answerSet.add(answerIntB);
                    }else{
                        answerSet.add(chnkNumbersRepository.getAllByValue(chnkNumber2.getValue()).get(0));
                    }
                    chnkLeetCodeNum.setAnswer(answerSet);

                    for (ChnkNumber chnkNumber : chnkLeetCodeNum.getNums()){
                        if (chnkNumbersRepository.getAllByValue(chnkNumber.getValue()).size() == 0) {
                            ChnkNumber num = new ChnkNumber();
                            num.setValue(chnkNumber.getValue());
                            chnkNumbersRepository.save(num);
                            numberSet.add(num);
                        }else{
                            numberSet.add(chnkNumbersRepository.getAllByValue(chnkNumber.getValue()).get(0));
                        }
                    }
                    chnkLeetCodeNum.setNums(numberSet);

                    ChnkNumber target = new ChnkNumber();
                    if (chnkNumbersRepository.getAllByValue(chnkLeetCodeNum.getTarget().getValue()).size() == 0) {
                        target.setValue(chnkLeetCodeNum.getTarget().getValue());
                        chnkNumbersRepository.save(target);
                    }else {
                        target = chnkNumbersRepository.getAllByValue(chnkLeetCodeNum.getTarget().getValue()).get(0);
                    }
                    chnkLeetCodeNum.setTarget(target);

                    return chnkLeetCodeNumRepository.save(chnkLeetCodeNum);
                }
            }
        }
        return null;
    }
}
