package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.*;
import com.example.downtime.repositories.*;

import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
@RequiredArgsConstructor
public class DownTimeService {

    private final WiseLostTimeRepository wiseLostTimeRepository;
    private final MachineBrokenRepository machineBrokenRepository;
    private final IssueTypeKeyCodeRepository issueTypeKeyCodeRepository;
    private final IssueTypeMechanicRepository issueTypeMechanicRepository;
    private final MainDownTimeRepository mainDownTimeRepository;
    private final FactoryRepository factoryRepository;

    private final Util util;


    public ApiResponse getMachineWiseLostTime(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize
    ) {
        List<MachineWiseLostTimeModel> result = wiseLostTimeRepository.getMachineWiseLostTime(facZone, facLine, startTime, endTime, pageNum, pageSize);
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

    public ApiResponse getIssueKeyCode(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<IssueTypeKeyCodeModel> result = issueTypeKeyCodeRepository.getIssueTypeKeyCode(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse paginationResponse = new PaginationResponse(pageNum, pageSize, totalElements, result);
        return util.formatApi(paginationResponse);
    }


    public ApiResponse getIssueMechanic(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<IssueTypeMechanic> result = issueTypeMechanicRepository.getIssueTypeMechanic(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse paginationResponse = new PaginationResponse(pageNum, pageSize, totalElements, result);
        return util.formatApi(paginationResponse);
    }

    public ApiResponse getMainDownTime(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<MainDownTimeModel> result = mainDownTimeRepository.getMainDownTime(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = result.get(0).getTotalElements();
        PaginationResponse paginationResponse = new PaginationResponse(pageNum, pageSize, totalElements, result);
        return util.formatApi(paginationResponse);
    }

    public ApiResponse getFac() {

        List<FactoryModel> listFac = factoryRepository.getFac();
        Map<String, List<String>> groupedData = util.groupByFacZone(listFac, FactoryModel::getFacZone, FactoryModel::getFacLine);

        PaginationResponse paginationResponse = new PaginationResponse(1, 1, 1, List.of(groupedData));
        return util.formatApi(paginationResponse);
    }

}


