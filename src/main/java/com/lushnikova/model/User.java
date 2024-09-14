package com.lushnikova.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
