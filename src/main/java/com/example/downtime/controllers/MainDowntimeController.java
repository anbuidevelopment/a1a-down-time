package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.service.MainDowntimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainDowntimeController extends Controller {
    private final MainDowntimeService mainDowntimeService;

    @GetMapping("/get-main-down-time")
    public ApiResponse getMainDownTime(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return mainDowntimeService.getMainDownTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);

    }
}