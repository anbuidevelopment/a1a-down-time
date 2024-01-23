package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.constants.Constants;
import com.example.downtime.models.MainDownTimeModel;
import com.example.downtime.service.MainDowntimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.BASE_URL)
@CrossOrigin
public class MainDowntimeController {
    private final MainDowntimeService mainDowntimeService;

    @GetMapping(Constants.URL_GET_MAIN_DOWN_TIME)
    public ApiResponse<MainDownTimeModel> getMainDownTime(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return mainDowntimeService.getMainDownTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);

    }
}
