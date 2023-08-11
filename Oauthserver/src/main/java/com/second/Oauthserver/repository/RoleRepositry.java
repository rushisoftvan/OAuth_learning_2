package com.second.Oauthserver.repository;

import com.second.Oauthserver.entity.RoleEntity;
import com.second.Oauthserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepositry extends JpaRepository<RoleEntity,Integer> {


}
