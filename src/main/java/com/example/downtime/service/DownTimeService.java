package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
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
            , String startTime, String endTime,int pageNum,int pageSize
    ) {
        List<MachineWiseLostTimeModel> result = wiseLostTimeRepository.getMachineWiseLostTime(facZone, facLine, startTime, endTime,pageNum,pageSize);
        List<MachineWiseLostTimeModel> resultPage1 = wiseLostTimeRepository.getMachineWiseLostTime( facZone, facLine, startTime, endTime,1, 1);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements);
        return res;
    }

    public ApiResponse getMachineBroken (String facZone, String facLine
            , String startTime, String endTime,int pageNum,int pageSize
    ) {
        List<MachineBrokenModel> result = machineBrokenRepository.getMachineBroken(facZone, facLine, startTime, endTime,pageNum,pageSize);
        List<MachineBrokenModel> resultPage1 = machineBrokenRepository.getMachineBroken(facZone, facLine, startTime, endTime,1, 1);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements);

        return res;
    }

    public ApiResponse getIssueKeyCode(String facZone, String facLine
            , String startTime, String endTime,int pageNum,int pageSize) {

        List<IssueTypeKeyCodeModel> result = issueTypeKeyCodeRepository.getIssueTypeKeyCode(facZone, facLine, startTime, endTime,pageNum,pageSize);
        List<IssueTypeKeyCodeModel> resultPage1 = issueTypeKeyCodeRepository.getIssueTypeKeyCode(facZone, facLine, startTime, endTime,1, 1);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements);

        return res;
    }


    public ApiResponse getIssueMechanic(String facZone, String facLine
            , String startTime, String endTime,int pageNum,int pageSize) {

        List<IssueTypeMechanic> result = issueTypeMechanicRepository.getIssueTypeMechanic(facZone, facLine, startTime, endTime,pageNum,pageSize);
        List<IssueTypeMechanic> resultPage1 = issueTypeMechanicRepository.getIssueTypeMechanic(facZone, facLine, startTime, endTime,1, 1);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum, totalElements);

        return res;
    }

    public ApiResponse getMainDownTime(String facZone, String facLine
            , String startTime, String endTime,int pageNum,int pageSize) {

        List<MainDownTimeModel> result = mainDownTimeRepository.getMainDownTime(facZone, facLine, startTime, endTime,pageNum,pageSize);
        List<MainDownTimeModel> resultPage1 = mainDownTimeRepository.getMainDownTime(facZone, facLine, startTime, endTime,1, 1);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements);

        return res;
    }

    public ApiResponse getFac() {

        List<FactoryModel> listFac = factoryRepository.getFac();
        Map<String, List<String>> groupedData = util.groupByFacZone(listFac, FactoryModel::getFacZone, FactoryModel::getFacLine);

        ApiResponse res = util.FormatApi(List.of(groupedData), 1,1,1);
        return res;
    }

}


