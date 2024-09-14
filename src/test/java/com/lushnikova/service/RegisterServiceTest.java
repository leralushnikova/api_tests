package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.request.RegisterRequest;
import com.lushnikova.dto.response.ErrorResponse;
import com.lushnikova.dto.response.RegisterResponse;
import com.lushnikova.exception.ModelNotFound;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static com.lushnikova.consts.WebConsts.REGISTER_PATH;
import static com.lushnikova.consts.WebConsts.SITE;
import static org.junit.jupiter.api.Assertions.*;

class RegisterServiceTest {

    String register = SITE + REGISTER_PATH;
    JsonMapper jsonMapper = new JsonMapper();
    UriService uriService = new UriService();
    HttpClient httpClient = HttpClient.newHttpClient();
    RegisterService registerService = new RegisterService(register, uriService, httpClient, jsonMapper);

    @Test
    void shouldCreateService() throws IOException, InterruptedException, ModelNotFound {
        RegisterRequest request = RegisterRequest.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();

        RegisterResponse response = RegisterResponse.builder()
                .id(4L)
                .token("QpwL5tke4Pnpja7X4")
                .build();


        assertEquals(response.toString(), registerService.createRegisterResponse(request).toString());
    }

    @Test
    void shouldNotCreateService() throws IOException, InterruptedException, ModelNotFound {
        RegisterRequest request = RegisterRequest.builder()
                .email("eve.holt@reqres.in")
                .build();

        var httpResponse = registerService.getHttpResponse(request);

        assertEquals("Missing password", errorResponse(httpResponse).getError());
        assertEquals(400, registerService.getStatusCode());

    }

    /*private String getError() throws JsonProcessingException {
        return jsonMapper.writeValueAsString(new ErrorResponse("Missing password"));
    }
*/
    private ErrorResponse errorResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), ErrorResponse.class);
    }
}