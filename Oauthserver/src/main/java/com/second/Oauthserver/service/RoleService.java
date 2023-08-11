package com.second.Oauthserver.service;

import com.second.Oauthserver.Exception.RoleNotFoundException;
import com.second.Oauthserver.entity.RoleEntity;
import com.second.Oauthserver.repository.RoleRepositry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepositry roleRepositry;

     public RoleEntity getRoleById(Integer roleId){
         Optional<RoleEntity> roleById = this.roleRepositry.findById(roleId);
         if(roleById.isPresent()){
             System.out.println(roleById.get().getName());
             return roleById.get();
         }
         throw new RoleNotFoundException("role is not found for this id : " + roleId);
     }
}
