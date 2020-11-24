package com.example.navigator.common.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequest {
    private int page;
    private int size;
//    private List<FilterRule> filterRules;
//    private List<SortRule> sortRules;
    private String searchText;




}
