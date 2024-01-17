package com.example.downtime.ApiResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String message;
    private DataResponse data;
}

