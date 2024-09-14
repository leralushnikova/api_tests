package com.lushnikova.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Login {
    private Long id;
    private String email;
    private String password;
    private String token;
}
