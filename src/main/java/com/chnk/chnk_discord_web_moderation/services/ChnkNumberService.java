package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.repositories.NumbersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChnkNumberService {
    private final NumbersRepository numbersRepository;
    public ChnkNumberService(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }

    public Integer sumNumbers(Integer a, Integer b){
        return a + b;
    }

    public ChnkNumber saveNumber(ChnkNumber chnkNumber){
        chnkNumber = numbersRepository.save(chnkNumber);
        return chnkNumber;
    }

    public List<ChnkNumber> getByValue(Integer value){
        return numbersRepository.getAllByValue(value);
    }

    public ChnkNumber getById(UUID id){
        return numbersRepository.getById(id);
    }
}
