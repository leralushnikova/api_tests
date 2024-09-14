package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.request.LoginRequest;
import com.lushnikova.dto.response.LoginResponse;
import com.lushnikova.exception.ModelNotFound;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class LoginService {

    private final String site;
    private final UriService uriService;
    private final HttpClient httpClient;
    private final JsonMapper jsonMapper;

    private LoginResponse getRegisterFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), LoginResponse.class);
    }

    public  LoginResponse createRegisterResponse(LoginRequest request) throws IOException, InterruptedException, ModelNotFound {
        if(request.getPassword() == null) {
            throw new ModelNotFound();
        };
        String strRequest = jsonMapper.writeValueAsString(request);
        return getRegisterFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(strRequest))
                .build(), HttpResponse.BodyHandlers.ofString()));
    }
}
