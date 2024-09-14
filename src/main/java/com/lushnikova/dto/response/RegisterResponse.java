package com.lushnikova.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterResponse {
    private Long id;
    private String token;
}
