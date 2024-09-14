package com.lushnikova.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Resource {
    private Long id;
    private String name;
    private Integer year;
    private String color;
    private String pantone_value;
}
