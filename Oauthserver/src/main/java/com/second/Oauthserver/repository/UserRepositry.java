package com.second.Oauthserver.repository;

import com.second.Oauthserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<UserEntity,Integer> {

    @Query("SELECT ue FROM UserEntity ue join fetch ue.role WHERE ue.email = :email")
    Optional<UserEntity> getUserByUsername(@Param("email") String username);
}
