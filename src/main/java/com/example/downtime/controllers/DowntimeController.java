package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.models.*;
import com.example.downtime.service.DownTimeService;

import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/api/v1/Downtime")
@RequiredArgsConstructor
public class DowntimeController {

    private final DownTimeService service;

    @GetMapping("/get-wise-lost-time")
    public ApiResponse getWiseLostTime(@RequestParam("s") Integer pageSize,
                                          @RequestParam("p") Integer pageNumber,
                                          @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                          @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                          @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                          @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getMachineWiseLostTime(pageSize,pageNumber,facZone,facLine,startTime,endTime);
    }

    @GetMapping("/get-broken")
    public  ApiResponse getMachineBroken(@RequestParam("s") Integer pageSize,
                                                           @RequestParam("p") Integer pageNumber,
                                                           @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                                           @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                                           @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                                           @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getMachineBroken(pageSize,pageNumber,facZone,facLine,startTime,endTime
        );
    }

    @GetMapping("/get-issue-keycode")
    public  ApiResponse getIssueKeyCode(@RequestParam("s") Integer pageSize,
                                                         @RequestParam("p") Integer pageNumber,
                                                         @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                                         @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                                         @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                                         @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getIssueKeyCode(pageSize,pageNumber,facZone,facLine,startTime,endTime
        );
    }

    @GetMapping(value = "/get-issue-mechanic")
    public ApiResponse getIssueMechanic(@RequestParam("s") Integer pageSize,
                                                    @RequestParam("p") Integer pageNumber,
                                                    @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                                    @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                                    @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                                    @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {

        return  service.getIssueMechanic(pageSize,pageNumber,facZone,facLine,startTime,endTime);
    }


    @GetMapping("/get-main-down-time")
    public  ApiResponse getMainDownTime(@RequestParam("s") Integer pageSize,
                                          @RequestParam("p") Integer pageNumber,
                                          @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                          @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                          @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                          @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getMainDownTime(pageSize,pageNumber,facZone,facLine,startTime,endTime);

    }

    @GetMapping("/fac")
    public ApiResponse getFac() {
        return service.getFac();
    }

}
