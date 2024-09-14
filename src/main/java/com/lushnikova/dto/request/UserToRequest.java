package com.lushnikova.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserToRequest {
    private String name;
    private String job;
}
