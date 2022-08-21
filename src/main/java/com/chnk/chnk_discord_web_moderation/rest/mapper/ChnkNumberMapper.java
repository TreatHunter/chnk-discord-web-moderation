package com.chnk.chnk_discord_web_moderation.rest.mapper;

import com.chnk.chnk_discord_web_moderation.entities.ChnkNumber;
import com.chnk.chnk_discord_web_moderation.rest.dto.ChnkNumberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChnkNumberMapper {
    ChnkNumberDto toNumberDto(ChnkNumber chnkNumber);
    ChnkNumber toNumber (ChnkNumberDto chnkNumberDto);
    List<ChnkNumberDto> toNumberDto(List<ChnkNumber> listChnkNumber);
    List<ChnkNumber> toNumber(List<ChnkNumberDto> listChnkNumberDto);
}
