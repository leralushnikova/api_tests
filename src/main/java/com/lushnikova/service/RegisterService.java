package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.request.RegisterRequest;
import com.lushnikova.dto.response.RegisterResponse;
import com.lushnikova.exception.ModelNotFound;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class RegisterService {

    private final String site;
    private final UriService uriService;
    private final HttpClient httpClient;
    private final JsonMapper jsonMapper;

    @Getter
    private Integer statusCode;

    private RegisterResponse getRegisterFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), RegisterResponse.class);
    }

    public RegisterResponse createRegisterResponse(RegisterRequest request) throws IOException, InterruptedException, ModelNotFound {
        if(request.getPassword() == null) {
            getHttpResponse(request);
            throw new ModelNotFound();
        }
        return getRegisterFromResponse(getHttpResponse(request));
    }

    public HttpResponse<String> getHttpResponse(RegisterRequest request) throws IOException, InterruptedException {
        String strRequest = jsonMapper.writeValueAsString(request);
        var response = httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(strRequest))
                .build(), HttpResponse.BodyHandlers.ofString());
        this.statusCode = response.statusCode();
        return response;
    }



}
