package com.lushnikova.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.PageDTOUser;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
public class PageDTOUserService {

    private final String site;
    private final UriService uriService;
    private final HttpClient httpClient;
    private final JsonMapper jsonMapper;

    private PageDTOUser getPageDTOFromResponse(HttpResponse<String> response) throws JsonProcessingException {
        return jsonMapper.readValue(response.body(), PageDTOUser.class);
    }

    public PageDTOUser getPageDTO() throws IOException, InterruptedException {
        return getPageDTOFromResponse(httpClient.send(HttpRequest.newBuilder()
                .uri(uriService.createUri(site))
                .GET()
                .build(), HttpResponse.BodyHandlers.ofString()));
    }
}
