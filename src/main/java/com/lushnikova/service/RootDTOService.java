package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.RootDTO;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@RequiredArgsConstructor
public class RootDTOService<T> {

    private final String site;
    private final UriService uriService;
    private final HttpClient httpClient;
    private final JsonMapper jsonMapper;


    private RootDTO<T> getRootDTOFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), RootDTO.class);
    }

    public  String getRootDTO() throws IOException, InterruptedException {
        return getRootDTOFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString())).toString();
    }
}
