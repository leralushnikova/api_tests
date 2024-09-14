package com.lushnikova.mapper;


import com.lushnikova.dto.request.RegisterRequest;
import com.lushnikova.dto.response.RegisterResponse;
import com.lushnikova.model.Register;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RegisterMapper {
    RegisterMapper INSTANCE = Mappers.getMapper(RegisterMapper.class);

    Register mapToModelRequest(RegisterRequest dto);

    RegisterResponse mapToResponse(Register register);
}
