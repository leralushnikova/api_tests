package com.lushnikova.mapper;

import com.lushnikova.dto.response.UserResponse;
import com.lushnikova.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse mapToResponse(User user);

}
