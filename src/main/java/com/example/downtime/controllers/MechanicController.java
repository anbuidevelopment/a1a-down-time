package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.constants.Constants;
import com.example.downtime.models.MachineBrokenModel;
import com.example.downtime.models.MachineWiseLostTimeModel;
import com.example.downtime.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.BASE_URL)
@CrossOrigin
public class MechanicController {

    private final MachineService machineService;

    @GetMapping(Constants.URL_GET_MACHINE_BROKEN)
    public ApiResponse<MachineBrokenModel> getMachineBroken(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineBroken(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping(Constants.URL_GET_MACHINE_LOST_TIME)
    public ApiResponse<MachineWiseLostTimeModel> getWiseLostTime(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return machineService.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

}
