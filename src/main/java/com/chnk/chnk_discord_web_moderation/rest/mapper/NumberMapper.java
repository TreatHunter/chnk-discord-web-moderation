package com.chnk.chnk_discord_web_moderation.rest.mapper;

import com.chnk.chnk_discord_web_moderation.entities.Number;
import com.chnk.chnk_discord_web_moderation.rest.dto.NumberDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NumberMapper {
    NumberDto toNumberDto(Number number);
    Number toNumber (NumberDto numberDto);
}
