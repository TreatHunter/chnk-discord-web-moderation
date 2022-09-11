package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkLeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkNumbersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LeetCodeService {
    private final ChnkLeetCodeNumRepository chnkLeetCodeNumRepository;
    private final ChnkNumbersRepository chnkNumbersRepository;

    public LeetCodeService(ChnkLeetCodeNumRepository chnkLeetCodeNumRepository, ChnkNumbersRepository chnkNumbersRepository) {
        this.chnkLeetCodeNumRepository = chnkLeetCodeNumRepository;
        this.chnkNumbersRepository = chnkNumbersRepository;
    }

    public ChnkLeetCodeNum twoSum(ChnkLeetCodeNum chnkLeetCodeNum) {
        List<ChnkNumber> answerList = new ArrayList<>();
        int i = 0;
        while (i < chnkLeetCodeNum.getNums().size()) {
            int j = 0;
            while (j + i < chnkLeetCodeNum.getNums().size()) {
                if (chnkLeetCodeNum.getNums().get(i).getValue() + chnkLeetCodeNum.getNums().get(j).getValue() == chnkLeetCodeNum.getTarget().getValue()) {
                    ChnkNumber num1 = chnkLeetCodeNum.getNums().get(i);
                    ChnkNumber num2 = chnkLeetCodeNum.getNums().get(j);
                    answerList.add(chnkNumbersRepository.getFirstByValue(num1.getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(num1)));
                    answerList.add(chnkNumbersRepository.getFirstByValue(num2.getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(num2)));
                    chnkLeetCodeNum.setAnswer(answerList);

                    chnkLeetCodeNum.setNums(chnkLeetCodeNum
                            .getNums()
                            .stream()
                            .map(chnkNumber ->
                                    chnkNumbersRepository.getFirstByValue(chnkNumber.getValue()).orElseGet(() ->
                                            chnkNumbersRepository.save(chnkNumber)
                                    )
                            ).collect(Collectors.toList()));

                    chnkLeetCodeNum.setTarget(chnkNumbersRepository.getFirstByValue(chnkLeetCodeNum.getTarget().getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(chnkLeetCodeNum.getTarget())));

                    return chnkLeetCodeNumRepository.save(chnkLeetCodeNum);
                }
                j++;
            }
            i++;
        }
        return null;
    }
}
