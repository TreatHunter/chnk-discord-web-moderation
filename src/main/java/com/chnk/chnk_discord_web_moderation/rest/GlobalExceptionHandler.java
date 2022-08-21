package com.chnk.chnk_discord_web_moderation.rest;

import com.chnk.chnk_discord_web_moderation.exceptions.NotFoundException;
import com.chnk.chnk_discord_web_moderation.rest.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException ex, HttpServletRequest httpServletRequest){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setErrors(Collections.singletonList(ex.getMessage()));
        exceptionDto.setPath(httpServletRequest.getRequestURI());
        exceptionDto.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionDto.setTimestamp(Calendar.getInstance().getTime().toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }
}
