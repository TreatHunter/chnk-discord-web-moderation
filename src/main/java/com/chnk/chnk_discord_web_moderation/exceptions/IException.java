package com.chnk.chnk_discord_web_moderation.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface IException {
    public HttpStatus getStatus();
    public List<String> getErrors();
}
