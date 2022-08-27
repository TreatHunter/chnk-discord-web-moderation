package com.chnk.chnk_discord_web_moderation.rest.mapper;

import com.chnk.chnk_discord_web_moderation.entities.ChnkLeetCodeNum;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkLeetCodeNumDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChnkLeetCodeNumMapper {
    ChnkLeetCodeNum toLeetCodeNum(ChnkLeetCodeNumDto chnkLeetCodeNumDto);
    ChnkLeetCodeNumDto toLeetCodeNumDto(ChnkLeetCodeNum chnkLeetCodeNum);
}
