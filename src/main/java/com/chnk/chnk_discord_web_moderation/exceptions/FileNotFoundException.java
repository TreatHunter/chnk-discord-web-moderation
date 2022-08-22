package com.chnk.chnk_discord_web_moderation.exceptions;

import java.util.Collections;
import java.util.List;

public class FileNotFoundException extends RuntimeException implements IException{
    private String path;

    public FileNotFoundException(String path){
        super();
        this.path = path;
    }

    @Override
    public Integer getStatus() {
        return 404;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList("File not found by path: " + path);
    }
}
