package com.lushnikova.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.request.UserToRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.lushnikova.consts.WebConsts.SITE;
import static com.lushnikova.consts.WebConsts.USER_PATH;
import static org.junit.jupiter.api.Assertions.*;

class UserToServiceTest {

    private final String userId = SITE + USER_PATH + "/" + 2;

    private final JsonMapper jsonMapper = new JsonMapper();
    private final UriService uriService = new UriService();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final UserToService userToService = new UserToService(userId, uriService, httpClient, jsonMapper);

    @Test
    void shouldDeleteUser() throws IOException, InterruptedException {

        assertEquals(204, userToService.deleteUserToResponse());

    }

    @Test
    void shouldUpdateUserWithMethodPatch() throws IOException, InterruptedException {

        UserToRequest userToRequest = UserToRequest.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        var userUpdatedAt = userToService.updateUserToResponsePatch(userToRequest).getUpdatedAt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lDate = LocalDate.parse(userUpdatedAt.substring(0, 10),formatter);
        LocalDateTime dateSystem = LocalDateTime.now();

        assertEquals(lDate.toString(), dateSystem.format(formatter));
    }

}