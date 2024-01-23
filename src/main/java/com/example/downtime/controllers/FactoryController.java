package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.constants.Constants;
import com.example.downtime.service.FactoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = Constants.BASE_URL)
@CrossOrigin
public class FactoryController {
    private final FactoryService factoryService;

    @GetMapping(Constants.URL_GET_FACTORY)
    public ApiResponse<Map<String, List<String>>> getFac() {
        return factoryService.getFac();
    }
}
