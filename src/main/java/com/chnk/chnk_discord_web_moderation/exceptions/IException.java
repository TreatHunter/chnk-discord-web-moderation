package com.chnk.chnk_discord_web_moderation.exceptions;

import java.util.List;

public interface IException {
    public Integer getStatus();
    public List<String> getErrors();
}
