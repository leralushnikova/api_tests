package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.request.UserToRequest;
import com.lushnikova.dto.response.UserToCreateResponse;
import com.lushnikova.dto.response.UserToUpdateResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class UserToService {

    private final String site;
    private final UriService uriService;
    private final HttpClient httpClient;
    private final JsonMapper jsonMapper;

    private UserToCreateResponse getUserTOCreateFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), UserToCreateResponse.class);
    }

    public String createUserToResponse(UserToRequest request) throws IOException, InterruptedException {
        String strRequest = jsonMapper.writeValueAsString(request);
        return getUserTOCreateFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(strRequest))
                .build(), HttpResponse.BodyHandlers.ofString())).toString();
    }

    public UserToUpdateResponse getUserToUpdateFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), UserToUpdateResponse.class);
    }

    public UserToUpdateResponse updateUserToResponse(UserToRequest request) throws IOException, InterruptedException {
        String strRequest = jsonMapper.writeValueAsString(request);
        return getUserToUpdateFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site + "/2"))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(strRequest))
                .build(), HttpResponse.BodyHandlers.ofString()));
    }

    public UserToUpdateResponse updateUserToResponsePatch(UserToRequest request) throws IOException, InterruptedException {
        String strRequest = jsonMapper.writeValueAsString(request);
        return getUserToUpdateFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site + "/2"))
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(strRequest))
                .build(), HttpResponse.BodyHandlers.ofString()));
    }


    public Integer deleteUserToResponse() throws IOException, InterruptedException {
        return httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site + "/2"))
                .header("Content-Type", "application/json")
                .DELETE()
                .build(), HttpResponse.BodyHandlers.ofString()).statusCode();
    }
}
