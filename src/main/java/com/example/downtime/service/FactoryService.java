package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.FactoryModel;
import com.example.downtime.repositories.FactoryRepository;
import com.example.downtime.utils.ApiConfig;
import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FactoryService {
    private final FactoryRepository factoryRepository;
    private final ApiConfig apiConfig;
    private final Util util;

    public ApiResponse<Map<String, List<String>>> getFac() {

        List<FactoryModel> listFac = factoryRepository.getFac();
        Map<String, List<String>> groupedData = util.groupByFacZone(listFac, FactoryModel::getFacZone, FactoryModel::getFacLine);

        PaginationResponse<Map<String, List<String>>> paginationResponse = new PaginationResponse<>(1, 1, 1, List.of(groupedData));
        return apiConfig.formatApi(paginationResponse);
    }
}
