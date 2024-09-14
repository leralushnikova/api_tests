package com.lushnikova.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
