package com.chnk.chnk_discord_web_moderation.rest;

import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkLeetCodeNumDto;
import com.chnk.chnk_discord_web_moderation.rest.mapper.ChnkLeetCodeNumMapper;
import com.chnk.chnk_discord_web_moderation.services.LeetCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LeetCodeRestController {
    private final LeetCodeService leetCodeService;
    private final ChnkLeetCodeNumMapper chnkLeetCodeNumMapper;

    public LeetCodeRestController(LeetCodeService leetCodeService, ChnkLeetCodeNumMapper chnkLeetCodeNumMapper){
        this.leetCodeService = leetCodeService;
        this.chnkLeetCodeNumMapper = chnkLeetCodeNumMapper;
    }

    @GetMapping("LeetCode_1")
    public ResponseEntity<ChnkLeetCodeNumDto> leetCode(){
        return ResponseEntity.ok(chnkLeetCodeNumMapper.toLeetCodeNumDto(leetCodeService.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
