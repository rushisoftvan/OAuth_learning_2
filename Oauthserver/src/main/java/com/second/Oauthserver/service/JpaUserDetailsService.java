package com.second.Oauthserver.service;

import com.second.Oauthserver.config.MyUserDetails;
import com.second.Oauthserver.dto.JpaGrantedAuthority;
import com.second.Oauthserver.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class JpaUserDetailsService implements UserDetailsService {


    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("<<<<<<<<<<<<< loadUserByUsername()");
        UserEntity userByUsername = userService.getUserByName(email);


//        JpaGrantedAuthority jpaGrantedAuthority = new JpaGrantedAuthority(userEntity.getRole());
//        log.info("loadUserByUsername() >>>>>");
//        return new MyUserDetails(userEntity, List.of(jpaGrantedAuthority));
        JpaGrantedAuthority jpaGrantedAuthority = new JpaGrantedAuthority(userByUsername.getRole());
        log.info("loadUserByUsername() >>>>>>>>>>>");
        return new MyUserDetails(userByUsername, List.of(jpaGrantedAuthority));

    }
}
