package com.lushnikova.mapper;

import com.lushnikova.dto.request.LoginRequest;
import com.lushnikova.dto.response.LoginResponse;
import com.lushnikova.model.Login;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoginMapper {
    LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);

    Login mapToModelRequest(LoginRequest dto);

    LoginResponse mapToResponse(Login login);
}
