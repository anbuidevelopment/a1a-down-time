package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.service.FactoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FactoryController extends Controller {
    private final FactoryService factoryService;

    @GetMapping("/fac")
    public ApiResponse getFac() {
        return factoryService.getFac();
    }
}
