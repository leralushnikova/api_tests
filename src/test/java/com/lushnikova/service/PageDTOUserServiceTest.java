package com.lushnikova.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.response.UserResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpClient;

import static com.lushnikova.consts.WebConsts.SITE;
import static com.lushnikova.consts.WebConsts.USER_PATH;
import static org.junit.jupiter.api.Assertions.*;

class PageDTOUserServiceTest {
    int page = 2;
    private final String usersSite = SITE + USER_PATH + "?page" + page;

    private final JsonMapper jsonMapper = new JsonMapper();
    private final UriService uriService = new UriService();
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final PageDTOUserService pageDTOUserServiceUserResponse = new PageDTOUserService(usersSite, uriService, httpClient, jsonMapper);

    @Test
    void shouldListPageDTO() throws IOException, InterruptedException {
        var pageDTO = pageDTOUserServiceUserResponse.getPageDTO();
        String endWith = "@reqres.in";
        var list = pageDTO.getData();
        boolean flag = true;
        for (UserResponse userResponse : list) {
            if(!userResponse.getEmail().endsWith(endWith)) {
                flag = false;
                break;
            }
        }

        assertTrue(flag);
    }
}