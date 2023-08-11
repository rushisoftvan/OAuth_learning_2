package com.second.Oauthserver.service;

import com.second.Oauthserver.entity.UserEntity;
import com.second.Oauthserver.entity.UserOneEntity;
import com.second.Oauthserver.repository.UserOneRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOneService {

    private final UserOneRepositry userOneRepositry;

    public void saveUserOne(UserOneEntity userOneEntity){
          this.userOneRepositry.save(userOneEntity);
    }
}
