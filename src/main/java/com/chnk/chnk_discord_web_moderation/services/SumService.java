package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.Number;
import com.chnk.chnk_discord_web_moderation.repositories.NumbersRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SumService {
    private final NumbersRepository numbersRepository;
    public SumService(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }

    public Integer sumNumbers(Integer a, Integer b){
        return a + b;
    }

    public Number saveNumber(Integer a){
        Number num = new Number();
        num.setNumber(a);
        num = numbersRepository.save(num);
        return num;
    }

    public Number getIdByValue(Integer value){
        return numbersRepository.getAllByNumber(value);
    }

    public Number getValueById(UUID id){
        return numbersRepository.getById(id);
    }
}
