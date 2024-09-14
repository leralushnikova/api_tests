package com.lushnikova.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Support {
    private String url;
    private String text;
}