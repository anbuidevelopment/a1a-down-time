package com.example.downtime.controllers;

import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.IssueTypeMechanic;
import com.example.downtime.models.MachineBrokenModel;
import com.example.downtime.models.MachineWiseLostTimeModel;
import com.example.downtime.service.DownTimeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/Downtime")
@RequiredArgsConstructor
public class DowntimeController {

    private final DownTimeService service;

    @GetMapping("/get-wise-lost-time")
    public  List<MachineWiseLostTimeModel> getWiseLostTime(@RequestParam("s") Integer pageSize,
                                                      @RequestParam("p") Integer pageNumber,
                                                      @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                                      @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                                      @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                                      @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getMachineWiseLostTime(pageSize,pageNumber,facZone,facLine,startTime,endTime
        );
    }

    @GetMapping("/get-broken")
    public  List<MachineBrokenModel> getMachineBroken(@RequestParam("s") Integer pageSize,
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
    public  List<IssueTypeKeyCodeModel> getIssueKeyCode(@RequestParam("s") Integer pageSize,
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

    @GetMapping("/get-issue-mechanic")
    public  List<IssueTypeMechanic> getIssueMechanic(@RequestParam("s") Integer pageSize,
                                                    @RequestParam("p") Integer pageNumber,
                                                    @RequestParam(value="f", required = false,defaultValue = "") String facZone,
                                                    @RequestParam(value="l", required = false,defaultValue = "") String facLine,
                                                    @RequestParam(value="start", required = false, defaultValue = "") String startTime,
                                                    @RequestParam(value="end", required = false, defaultValue = "") String endTime
    )
    {
        return service.getIssueMechanic(pageSize,pageNumber,facZone,facLine,startTime,endTime);

    }

}
