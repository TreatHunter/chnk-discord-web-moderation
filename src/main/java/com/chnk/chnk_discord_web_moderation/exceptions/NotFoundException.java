package com.chnk.chnk_discord_web_moderation.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super();
    }
    public NotFoundException(String msg){
        super(msg);
    }
}
