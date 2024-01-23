package com.example.downtime.ApiResponse;

import com.example.downtime.utils.Util;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class DataResponse<T> {
    private List<String> headers;
    private PaginationResponse<T> contents;

    public DataResponse(PaginationResponse<T> contents) {
        this.headers = contents.getHeaderDataList();
        this.contents = contents;
    }

 }
