package com.second.Oauthserver.Exception;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String msg){
        super(msg);
    }
}
