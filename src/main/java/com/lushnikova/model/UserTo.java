package com.lushnikova.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserTo {
    private Long id;
    private String name;
    private String job;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
