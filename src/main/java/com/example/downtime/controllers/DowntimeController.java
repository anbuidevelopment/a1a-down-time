package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.service.DownTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/v1/Downtime")
@RequiredArgsConstructor
@CrossOrigin
public class DowntimeController {

    private final DownTimeService service;

    @GetMapping("/get-wise-lost-time")
    public ApiResponse getWiseLostTime(@RequestParam("s") Integer pageSize,
                                       @RequestParam("p") Integer pageNumber,
                                       @RequestParam(value = "f", required = false, defaultValue = "") String facZone,
                                       @RequestParam(value = "l", required = false, defaultValue = "") String facLine,
                                       @RequestParam(value = "start", required = false) String startTime,
                                       @RequestParam(value = "end", required = false) String endTime
    ) {
        return service.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping("/get-broken")
    public ApiResponse getMachineBroken(@RequestParam("s") Integer pageSize,
                                        @RequestParam("p") Integer pageNumber,
                                        @RequestParam(value = "f", required = false, defaultValue = "") String facZone,
                                        @RequestParam(value = "l", required = false, defaultValue = "") String facLine,
                                        @RequestParam(value = "start", required = false) String startTime,
                                        @RequestParam(value = "end", required = false) String endTime
    ) {
        return service.getMachineBroken(facZone, facLine, startTime, endTime, pageNumber, pageSize
        );
    }

    @GetMapping("/get-issue-keycode")
    public ApiResponse getIssueKeyCode(@RequestParam("s") Integer pageSize,
                                       @RequestParam("p") Integer pageNumber,
                                       @RequestParam(value = "f", required = false, defaultValue = "") String facZone,
                                       @RequestParam(value = "l", required = false, defaultValue = "") String facLine,
                                       @RequestParam(value = "start", required = false) String startTime,
                                       @RequestParam(value = "end", required = false) String endTime
    ) {
        return service.getIssueKeyCode(facZone, facLine, startTime, endTime, pageNumber, pageSize
        );
    }

    @GetMapping(value = "/get-issue-mechanic")
    public ApiResponse getIssueMechanic(@RequestParam("s") Integer pageSize,
                                        @RequestParam("p") Integer pageNumber,
                                        @RequestParam(value = "f", required = false, defaultValue = "") String facZone,
                                        @RequestParam(value = "l", required = false, defaultValue = "") String facLine,
                                        @RequestParam(value = "start", required = false) String startTime,
                                        @RequestParam(value = "end", required = false) String endTime
    ) {

        return service.getIssueMechanic(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }


    @GetMapping("/get-main-down-time")
    public ApiResponse getMainDownTime(@RequestParam("s") Integer pageSize,
                                       @RequestParam("p") Integer pageNumber,
                                       @RequestParam(value = "f", required = false, defaultValue = "") String facZone,
                                       @RequestParam(value = "l", required = false, defaultValue = "") String facLine,
                                       @RequestParam(value = "start", required = false) String startTime,
                                       @RequestParam(value = "end", required = false) String endTime
    ) {
        return service.getMainDownTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);

    }

    @GetMapping("/fac")
    public ApiResponse getFac() {
        return service.getFac();
    }

}
