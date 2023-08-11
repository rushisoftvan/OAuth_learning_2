package com.second.Oauthserver.service;

import com.second.Oauthserver.Exception.UsernameNotFoundException;
import com.second.Oauthserver.Mapper.UserMapper;
import com.second.Oauthserver.dto.request.UserRegisterRequest;
import com.second.Oauthserver.entity.RoleEntity;
import com.second.Oauthserver.entity.UserEntity;
import com.second.Oauthserver.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepositry userRepositry;

    private final UserMapper userMapper;

    private final RoleService roleService;


    public UserEntity getUserByName(String email){
        Optional<UserEntity> userByUsername = this.userRepositry.getUserByUsername(email);
        if(userByUsername.isPresent()){
            log.info("username {}", userByUsername.get().getEmail());
            return userByUsername.get();
        }
        throw new UsernameNotFoundException("user is not found");
    }


   public Integer registerUser(UserRegisterRequest userRegisterRequest){

       RoleEntity roleById = this.roleService.getRoleById(userRegisterRequest.getRoleId());
       log.info("roleById",roleById.getName());
       //UserEntity userEntity = this.userMapper.toEntity(userRegisterRequest);
       UserEntity userEntity = new UserEntity();
       userEntity.setFirstname(userRegisterRequest.getFirstname());
       userEntity.setEmail(userRegisterRequest.getEmail());
       userEntity.setPassword(userRegisterRequest.getPassword());
       userEntity.setRole(roleById);

       log.info("name",roleById.getName());
       
       UserEntity savedUser = this.userRepositry.save(userEntity);
      return savedUser.getId();
   }
}
