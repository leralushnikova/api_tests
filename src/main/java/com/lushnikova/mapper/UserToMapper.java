package com.lushnikova.mapper;

import com.lushnikova.dto.request.UserToRequest;
import com.lushnikova.dto.response.UserToCreateResponse;
import com.lushnikova.dto.response.UserToUpdateResponse;
import com.lushnikova.model.UserTo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserToMapper {

    UserToMapper INSTANCE = Mappers.getMapper(UserToMapper.class);

    UserTo mapToModelRequest(UserToRequest dto);

    UserToCreateResponse mapToCreateResponse(UserTo userto);

    UserToUpdateResponse mapToUpdateResponse(UserTo userto);

}
