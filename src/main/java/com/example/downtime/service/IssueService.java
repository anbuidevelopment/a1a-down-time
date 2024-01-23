package com.example.downtime.service;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.ApiResponse.PaginationResponse;
import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.IssueTypeMechanic;
import com.example.downtime.repositories.IssueTypeKeyCodeRepository;
import com.example.downtime.repositories.IssueTypeMechanicRepository;
import com.example.downtime.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssueService {

    private final IssueTypeMechanicRepository issueTypeMechanicRepository;
    private final IssueTypeKeyCodeRepository issueTypeKeyCodeRepository;

    private final Util util;

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
}
