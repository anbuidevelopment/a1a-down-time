package com.example.downtime.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse {
    private int pageIndex;
    private int rowPerPage;
    private int totalElements;
    private int totalPages;
    private List<?> dataList;
}
