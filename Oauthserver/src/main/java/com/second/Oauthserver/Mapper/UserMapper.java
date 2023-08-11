package com.second.Oauthserver.Mapper;

import com.second.Oauthserver.dto.request.UserRegisterRequest;
import com.second.Oauthserver.entity.UserEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface UserMapper {
     UserEntity toEntity(UserRegisterRequest createUserRequest);
}
