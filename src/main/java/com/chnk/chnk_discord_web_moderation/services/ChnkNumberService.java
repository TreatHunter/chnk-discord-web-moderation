package com.chnk.chnk_discord_web_moderation.services;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.exceptions.DivideByZeroException;
import com.chnk.chnk_discord_web_moderation.exceptions.FileNotFoundException;
import com.chnk.chnk_discord_web_moderation.exceptions.FoundSeveralIdenticalNumberException;
import com.chnk.chnk_discord_web_moderation.exceptions.NotFoundException;
import com.chnk.chnk_discord_web_moderation.repositories.NumbersRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        List<ChnkNumber> numbers = numbersRepository.getAllByValue(value);
        if (numbers.size() > 1) throw new FoundSeveralIdenticalNumberException(numbers);
        return numbers;
    }

    public ChnkNumber getById(UUID id){
        return numbersRepository.findById(id).orElseThrow(() -> {throw new NotFoundException(id, "Hello! NotFound Exception!!!");});
    }

    public Double divideNumbers(Double a, Double b){
        if (b == 0.0) throw new DivideByZeroException(a, b);
        return a / b;
    }

    public String openFile() {
        Path path = Paths.get("src/test/resources/fileTest.txt");
        try {
            String line = Files.readAllLines(path).get(0);
            return line;
        } catch (IOException e) {
            throw new FileNotFoundException(path.toString());
        }
    }
}
