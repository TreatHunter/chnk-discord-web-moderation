package com.chnk.chnk_discord_web_moderation.rest.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ExceptionDto {
    private String timestamp;
    private HttpStatus status;
    private List<String> errors;
    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
