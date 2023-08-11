package com.second.Oauthserver.dto;

import com.second.Oauthserver.entity.RoleEntity;
import com.second.Oauthserver.repository.RoleRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class JpaGrantedAuthority implements GrantedAuthority {

    private final RoleEntity roleEntity;
    @Override
    public String getAuthority() {
        return this.roleEntity.getName();
    }


}
