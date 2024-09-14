package com.lushnikova.dto;

import com.lushnikova.dto.response.UserResponse;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTOUser {
    private int page; // какая страница
    private int per_page; //  сколько объектов в данной странице
    private long total; // сколько всего объектов
    private int total_pages; //сколько всего страниц
    private List<UserResponse> data;
    private Support support;
}
