package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.constants.Constants;
import com.example.downtime.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.BASE_URL)
public class MechanicController {

    private final MachineService machineService;

    @GetMapping(Constants.URL_GET_MACHINE_BROKEN)
    public ApiResponse getMachineBroken(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineBroken(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping(Constants.URL_GET_MACHINE_LOST_TIME)
    public ApiResponse getWiseLostTime(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

}
