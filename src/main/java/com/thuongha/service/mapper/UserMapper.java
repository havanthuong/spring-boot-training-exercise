package com.thuongha.service.mapper;

import org.mapstruct.Mapper;
import com.thuongha.entity.User;
import com.thuongha.service.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User> {
    User toEntity(UserDto dto);
}
