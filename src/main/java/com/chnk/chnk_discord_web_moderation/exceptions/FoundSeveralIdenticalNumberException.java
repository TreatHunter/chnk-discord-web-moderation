package com.chnk.chnk_discord_web_moderation.exceptions;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;

import java.util.ArrayList;
import java.util.List;

public class FoundSeveralIdenticalNumberException extends RuntimeException implements IException{
    private List<String> numbers = new ArrayList<String>();

    public FoundSeveralIdenticalNumberException(List<ChnkNumber> numbers){
        super();
        this.numbers.add("Found several identical numbers:");
        for (ChnkNumber number : numbers){
            this.numbers.add(number.getValue().toString());
        }
    }

    @Override
    public Integer getStatus() {
        return 501;
    }

    @Override
    public List<String> getErrors() {
        return numbers;
    }
}
