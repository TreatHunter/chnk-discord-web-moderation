package com.chnk.chnk_discord_web_moderation.exceptions;

import java.util.Collections;
import java.util.List;

public class DivideByZeroException extends RuntimeException implements IException{
    private Double a;
    private Double b;
    public DivideByZeroException(Double a, Double b){
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer getStatus() {
        return 500;
    }

    @Override
    public List<String> getErrors() {
        return Collections.singletonList("Double " + a + " was divided by Double " + b);
    }
}
