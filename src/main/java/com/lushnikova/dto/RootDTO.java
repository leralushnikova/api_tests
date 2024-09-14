package com.lushnikova.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RootDTO<T>{
    private T data;
    private Support support;
}