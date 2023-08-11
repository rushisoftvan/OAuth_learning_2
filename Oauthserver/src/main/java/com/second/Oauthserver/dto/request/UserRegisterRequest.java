package com.second.Oauthserver.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {

    private String firstname;

    private String email;

    private String password;

    private Integer roleId;

}
