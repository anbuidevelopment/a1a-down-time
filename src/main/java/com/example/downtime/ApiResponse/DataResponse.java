package com.example.downtime.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class DataResponse {
    private List<?> headers;
    private PaginationResponse contents;
 }
