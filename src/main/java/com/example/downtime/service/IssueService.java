package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.IssueTypeMechanic;
import com.example.downtime.repositories.IssueTypeKeyCodeRepository;
import com.example.downtime.repositories.IssueTypeMechanicRepository;
import com.example.downtime.utils.ApiConfig;
import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueTypeMechanicRepository issueTypeMechanicRepository;
    private final IssueTypeKeyCodeRepository issueTypeKeyCodeRepository;

    private final ApiConfig apiConfig;

    public ApiResponse<IssueTypeKeyCodeModel> getIssueKeyCode(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<IssueTypeKeyCodeModel> result = issueTypeKeyCodeRepository.getIssueTypeKeyCode(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = 0;
        if(!result.isEmpty()) {
            totalElements = result.get(0).getTotalElements();
        }
        PaginationResponse<IssueTypeKeyCodeModel> paginationResponse = new PaginationResponse<>(pageNum, pageSize, totalElements, result);
        return apiConfig.formatApi(paginationResponse);
    }

    public ApiResponse<IssueTypeMechanic> getIssueMechanic(String facZone, String facLine
            , String startTime, String endTime, int pageNum, int pageSize) {

        List<IssueTypeMechanic> result = issueTypeMechanicRepository.getIssueTypeMechanic(facZone, facLine, startTime, endTime, pageNum, pageSize);
        Integer totalElements = 0;
        if(!result.isEmpty()) {
            totalElements = result.get(0).getTotalElements();
        }
        PaginationResponse<IssueTypeMechanic> paginationResponse = new PaginationResponse<>(pageNum, pageSize, totalElements, result);
        return apiConfig.formatApi(paginationResponse);
    }
}
