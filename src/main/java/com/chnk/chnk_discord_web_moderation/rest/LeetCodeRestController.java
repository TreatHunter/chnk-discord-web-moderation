package com.chnk.chnk_discord_web_moderation.rest;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkLeetCodeNumDto;
import com.chnk.chnk_discord_web_moderation.rest.dto.SetLeetCodeNumDto;
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

    @PostMapping("LeetCode_1")
    public ResponseEntity<ChnkLeetCodeNumDto> leetCode1(@RequestBody SetLeetCodeNumDto setLeetCodeNumDto){
        ChnkLeetCodeNum chnkLeetCodeNum = new ChnkLeetCodeNum();
        chnkLeetCodeNum.getNums().add(setLeetCodeNumDto.getChnkNumber());
        chnkLeetCodeNum.setTarget(setLeetCodeNumDto.getTarget());
        return ResponseEntity.ok(chnkLeetCodeNumMapper.toLeetCodeNumDto(leetCodeService.saveLeetCodeNum(leetCodeService.twoSum(chnkLeetCodeNum))));
    }
}
