package com.chnk.chnk_discord_web_moderation.rest.mapper;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkLeetCodeNumRequestDto;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkLeetCodeNumResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChnkLeetCodeNumMapper {
    ChnkLeetCodeNum toLeetCodeNum(ChnkLeetCodeNumRequestDto chnkLeetCodeNumDto);
    ChnkLeetCodeNumResponseDto toLeetCodeNumDto(ChnkLeetCodeNum chnkLeetCodeNum);
}
