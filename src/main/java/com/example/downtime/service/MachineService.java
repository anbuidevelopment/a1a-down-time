package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.MachineBrokenModel;
import com.example.downtime.models.MachineWiseLostTimeModel;
import com.example.downtime.repositories.MachineBrokenRepository;
import com.example.downtime.repositories.MachineWiseLostTimeRepository;
import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineService {

    private final MachineBrokenRepository machineBrokenRepository;
    private final MachineWiseLostTimeRepository machineWiseLostTimeRepository;

    private Util util;

    public ApiResponse getMachineWiseLostTime(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize
    ) {
        List<MachineWiseLostTimeModel> result = machineWiseLostTimeRepository.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse paginationResponse = new PaginationResponse(pageNum, pageSize, totalElements, result);
        return util.formatApi(paginationResponse);
    }

    public ApiResponse getMachineBroken(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize
    ) {
        List<MachineBrokenModel> result = machineBrokenRepository.getMachineBroken(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse paginationResponse = new PaginationResponse(pageNum, pageSize, totalElements, result);
        return util.formatApi(paginationResponse);
    }

}
