package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MechanicController extends Controller {

    private final MachineService machineService;

    @GetMapping("/get-broken")
    public ApiResponse getMachineBroken(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineBroken(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping("/get-wise-lost-time")
    public ApiResponse getWiseLostTime(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

}
