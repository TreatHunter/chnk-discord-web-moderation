package com.chnk.chnk_discord_web_moderation.exceptions;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NotFoundException extends RuntimeException implements IException{
    //List<String> el;
    private UUID uuid;

    public NotFoundException(UUID uuid, String msg){
        super();
        this.uuid = uuid;
    }

    @Override
    public Integer getStatus() {
        return 404;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList("Number not found by uuid: " + uuid);
    }
}
