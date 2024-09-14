package com.lushnikova.dto.response;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserToCreateResponse {
    private Long id;
    private String name;
    private String job;
    private String createdAt;
}
