package com.chnk.chnk_discord_web_moderation.controllers;

import com.chnk.chnk_discord_web_moderation.services.SumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestRestController {
    private final SumService sumService;

    public TestRestController(SumService sumService) {
        this.sumService = sumService;
    }

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World!" + sumService.sumNumbers(5,5));
    }

    @GetMapping("save-number/{num}")
    public ResponseEntity<String> setNumber(@PathVariable("num") Integer a){
        return ResponseEntity.ok(sumService.saveNumber(a).getPrimaryKey().toString());
    }
}
