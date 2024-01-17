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


    public ApiResponse getMachineWiseLostTime(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime
    ) {
        List<MachineWiseLostTimeModel> result = wiseLostTimeRepository.getMachineWiseLostTime(pageSize, pageNum, facZone, facLine, startTime, endTime);
        List<MachineWiseLostTimeModel> resultPage1 = wiseLostTimeRepository.getMachineWiseLostTime(1, 1, facZone, facLine, startTime, endTime);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements, MachineWiseLostTimeModel.class);
        return res;
    }

    public ApiResponse getMachineBroken (int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime
    ) {
        List<MachineBrokenModel> result = machineBrokenRepository.getMachineBroken(pageSize, pageNum, facZone, facLine, startTime, endTime);
        List<MachineBrokenModel> resultPage1 = machineBrokenRepository.getMachineBroken(1, 1, facZone, facLine, startTime, endTime);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements, MachineBrokenModel.class);

        return res;
    }

    public ApiResponse getIssueKeyCode(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime) {

        List<IssueTypeKeyCodeModel> result = issueTypeKeyCodeRepository.getIssueTypeKeyCode(pageSize, pageNum, facZone, facLine, startTime, endTime);
        List<IssueTypeKeyCodeModel> resultPage1 = issueTypeKeyCodeRepository.getIssueTypeKeyCode(1, 1, facZone, facLine, startTime, endTime);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements, IssueTypeKeyCodeModel.class);

        return res;
    }


    public ApiResponse getIssueMechanic(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime) {

        List<IssueTypeMechanic> result = issueTypeMechanicRepository.getIssueTypeMechanic(pageSize, pageNum, facZone, facLine, startTime, endTime);
        List<IssueTypeMechanic> resultPage1 = issueTypeMechanicRepository.getIssueTypeMechanic(1, 1, facZone, facLine, startTime, endTime);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum, totalElements, IssueTypeMechanic.class);

        return res;
    }

    public ApiResponse getMainDownTime(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime) {

        List<MainDownTimeModel> result = mainDownTimeRepository.getMainDownTime(pageSize, pageNum, facZone, facLine, startTime, endTime);
        List<MainDownTimeModel> resultPage1 = mainDownTimeRepository.getMainDownTime(1, 1, facZone, facLine, startTime, endTime);
        Integer totalElements = resultPage1.get(0).getTotalElements();
        ApiResponse res = util.FormatApi(result, pageSize,pageNum,totalElements, MainDownTimeModel.class);

        return res;
    }

    public ApiResponse getFac() {

        List<FactoryModel> listFac = factoryRepository.getFac();
        Map<String, List<String>> groupedData = util.groupByFacZone(listFac, FactoryModel::getFacZone, FactoryModel::getFacLine);

        ApiResponse res = util.FormatApi(List.of(groupedData), 1,1,1,null);
        return res;
    }

}


