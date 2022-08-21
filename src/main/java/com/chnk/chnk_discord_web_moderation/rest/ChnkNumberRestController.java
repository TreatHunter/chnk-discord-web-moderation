package com.chnk.chnk_discord_web_moderation.rest;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkNumberDto;
import com.chnk.chnk_discord_web_moderation.rest.mapper.ChnkNumberMapper;
import com.chnk.chnk_discord_web_moderation.services.ChnkNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class ChnkNumberRestController {
    private final ChnkNumberService chnkNumberService;
    private final ChnkNumberMapper chnkNumberMapper;

    public ChnkNumberRestController(ChnkNumberService chnkNumberService, ChnkNumberMapper chnkNumberMapper) {
        this.chnkNumberService = chnkNumberService;
        this.chnkNumberMapper = chnkNumberMapper;
    }

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World!" + chnkNumberService.sumNumbers(5,5));
    }

    @PostMapping("save-number")
    public ResponseEntity<ChnkNumberDto> setNumber(@RequestBody ChnkNumberDto chnkNumberDto){
        ChnkNumber chnkNumber = chnkNumberMapper.toNumber(chnkNumberDto);
        return ResponseEntity.ok(chnkNumberMapper.toNumberDto(chnkNumberService.saveNumber(chnkNumber)));
    }

    @GetMapping("get-number-by-id/{id}")
    public ResponseEntity<ChnkNumberDto> getNumberById(@PathVariable("id") UUID uuid){
        return ResponseEntity.ok(chnkNumberMapper.toNumberDto(chnkNumberService.getById(uuid)));
    }

    @GetMapping("get-number-by-value/{value}")
    public ResponseEntity<List<ChnkNumberDto>> getNumberByValue(@PathVariable("value") Integer value){
        return ResponseEntity.ok(chnkNumberMapper.toNumberDto(chnkNumberService.getByValue(value)));
    }
}
