package com.second.Oauthserver.Exception;

public class UsernameNotFoundException  extends RuntimeException{
    public UsernameNotFoundException(String msg){
        super(msg);
    }
}
