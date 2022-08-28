package com.chnk.chnk_discord_web_moderation.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class FileNotFoundException extends RuntimeException implements IException{
    private String path;

    public FileNotFoundException(String path){
        super();
        this.path = path;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList("File not found by path: " + path);
    }
}
