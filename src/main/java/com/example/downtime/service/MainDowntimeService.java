package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.MainDownTimeModel;
import com.example.downtime.repositories.MainDownTimeRepository;
import com.example.downtime.utils.ApiConfig;
import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainDowntimeService {

    private final MainDownTimeRepository mainDownTimeRepository;

    private final ApiConfig apiConfig;

    public ApiResponse<MainDownTimeModel> getMainDownTime(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<MainDownTimeModel> result = mainDownTimeRepository.getMainDownTime(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse<MainDownTimeModel> paginationResponse = new PaginationResponse<>(pageNum, pageSize, totalElements, result);
        return apiConfig.formatApi(paginationResponse);
    }


}
