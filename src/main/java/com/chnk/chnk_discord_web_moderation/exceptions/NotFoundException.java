package com.chnk.chnk_discord_web_moderation.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NotFoundException extends RuntimeException implements IException{
    private String msg;
    public NotFoundException(Integer value){
        super();
        msg = "Number " + value + " not found";
    }

    public NotFoundException(UUID id){
        super();
        msg = "Number not found by id: " + id;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList(msg);
    }
}
