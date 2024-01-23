package com.example.downtime.utils;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.DataResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiConfig {

    public <T> ApiResponse<T> formatApi(PaginationResponse<T> paginationResponse) {

        DataResponse<T> data = new DataResponse<T>(paginationResponse);

        return new ApiResponse<T>(HttpStatus.OK.value(), Constants.GET_SUCCESS_MESSAGE, data);
    }
}
