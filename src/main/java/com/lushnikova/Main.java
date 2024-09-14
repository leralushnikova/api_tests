package com.lushnikova;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.lushnikova.dto.PageDTOResource;
import com.lushnikova.dto.request.UserToRequest;
import com.lushnikova.dto.response.ResourceResponse;
import com.lushnikova.dto.response.UserResponse;
import com.lushnikova.service.*;

import java.io.IOException;
import java.net.http.HttpClient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.lushnikova.consts.WebConsts.*;

public class Main {

    private static final String user = SITE + USER_PATH;
    private static final String unknown = SITE + UNKNOWN_PATH;
    private static final String register = SITE + REGISTER_PATH;
    private static final String login = SITE + LOGIN_PATH;
    private static final String sitePageDtoUserResponse = user + "?page" + 2;
    private static final String siteDelay = user + "?delay=3";
    private static final String siteRootDtoUserResponse = user + "/" + 2;
    private static final String siteRootDtoResourceResponse = unknown + "/" + 2;



    private static final JsonMapper jsonMapper = new JsonMapper();
    private static final UriService uriService = new UriService();
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final PageDTOUserService PAGE_DTO_USER_SERVICE_USER_RESPONSE = new PageDTOUserService(siteDelay, uriService, httpClient, jsonMapper);
    private static final PageDTOResourceService pageDTOServiceResourceResponse = new PageDTOResourceService(unknown, uriService, httpClient, jsonMapper);
    private static final RootDTOService<UserResponse> rootDTOServiceUserResponse = new RootDTOService<>(siteRootDtoUserResponse, uriService, httpClient, jsonMapper);
    private static final RootDTOService<ResourceResponse> rootDTOServiceResourceResponse = new RootDTOService<>(siteRootDtoResourceResponse,uriService, httpClient, jsonMapper);
    private static final UserToService userToService = new UserToService(user, uriService, httpClient, jsonMapper);
    private static final RegisterService registerService = new RegisterService(register, uriService, httpClient, jsonMapper);
    private static final LoginService loginService = new LoginService(login, uriService, httpClient, jsonMapper);

    public static void main(String[] args) throws IOException, InterruptedException {
        UserToRequest userToRequest = UserToRequest.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        var userUpdatedAt = userToService.updateUserToResponsePatch(userToRequest).getUpdatedAt();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lDate = LocalDate.parse(userUpdatedAt.substring(0, 10),formatter);
        LocalDateTime dateSystem = LocalDateTime.now();

        System.out.println(lDate);
        System.out.println(dateSystem.format(formatter));
    }
}
