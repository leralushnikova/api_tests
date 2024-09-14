package com.lushnikova.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResourceResponse {
    private Long id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;
}
