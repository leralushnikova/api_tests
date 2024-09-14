package com.lushnikova.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RegisterRequest {
    private String email;
    private String password;
}
