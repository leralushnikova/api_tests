package com.lushnikova.dto;

import com.lushnikova.dto.response.ResourceResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDTOResource {
    private int page; // какая страница
    private int per_page; //  сколько объектов в данной странице
    private long total; // сколько всего объектов
    private int total_pages; //сколько всего страниц
    private List<ResourceResponse> data;
    private Support support;
}
