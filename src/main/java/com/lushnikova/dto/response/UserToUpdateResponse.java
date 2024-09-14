package com.lushnikova.dto.response;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserToUpdateResponse {
    private String name;
    private String job;
    private String updatedAt;
}
