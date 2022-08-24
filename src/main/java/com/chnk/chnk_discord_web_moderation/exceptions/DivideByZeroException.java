package com.chnk.chnk_discord_web_moderation.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class DivideByZeroException extends RuntimeException implements IException{
    private Integer a;
    private Integer b;
    public DivideByZeroException(Integer a, Integer b){
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList(a + " was divided by " + b);
    }
}
