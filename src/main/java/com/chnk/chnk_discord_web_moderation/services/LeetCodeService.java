package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkLeetCodeNumRepository;
import com.chnk.chnk_discord_web_moderation.repositories.ChnkNumbersRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        Set<ChnkNumber> answerSet = new HashSet<>();

        for (ChnkNumber chnkNumber1 : chnkLeetCodeNum.getNums()) {
            for (ChnkNumber chnkNumber2 : chnkLeetCodeNum.getNums()) {
                if (chnkNumber1.getValue() + chnkNumber2.getValue() == chnkLeetCodeNum.getTarget().getValue()) {

                    answerSet.add(chnkNumbersRepository.getFirstByValue(chnkNumber1.getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(chnkNumber1)));
                    answerSet.add(chnkNumbersRepository.getFirstByValue(chnkNumber2.getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(chnkNumber2)));
                    chnkLeetCodeNum.setAnswer(answerSet);

                    chnkLeetCodeNum.setNums(chnkLeetCodeNum
                            .getNums()
                            .stream()
                            .map(chnkNumber ->
                                    chnkNumbersRepository.getFirstByValue(chnkNumber.getValue()).orElseGet(() ->
                                            chnkNumbersRepository.save(chnkNumber)
                                    )
                            ).collect(Collectors.toSet()));

                    chnkLeetCodeNum.setTarget(chnkNumbersRepository.getFirstByValue(chnkLeetCodeNum.getTarget().getValue())
                            .orElseGet(() ->
                                    chnkNumbersRepository.save(chnkLeetCodeNum.getTarget())));

                    return chnkLeetCodeNumRepository.save(chnkLeetCodeNum);
                }
            }
        }
        return null;
    }
}
