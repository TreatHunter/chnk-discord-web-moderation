package com.chnk.chnk_discord_web_moderation.rest;

import com.chnk.chnk_discord_web_moderation.exceptions.*;
import com.chnk.chnk_discord_web_moderation.rest.dto.ExceptionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleException(Exception ex, HttpServletRequest httpServletRequest){
        ExceptionDto exceptionDto = new ExceptionDto();
        IException iException = (IException) ex;

        exceptionDto.setStatus(iException.getStatus());
        exceptionDto.setErrors(iException.getErrors());

        exceptionDto.setPath(httpServletRequest.getRequestURI());
        exceptionDto.setTimestamp(Calendar.getInstance().getTime().toString());
        return ResponseEntity.status(iException.getStatus()).body(exceptionDto);
    }
}
