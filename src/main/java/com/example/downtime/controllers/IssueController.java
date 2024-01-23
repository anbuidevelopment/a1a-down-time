package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.constants.Constants;
import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.IssueTypeMechanic;
import com.example.downtime.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constants.BASE_URL)
@CrossOrigin
public class IssueController {

    private final IssueService issueService;

    @GetMapping(Constants.URL_GET_ISSUE_KEY_CODE)
    public ApiResponse<IssueTypeKeyCodeModel> getIssueKeyCode(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return issueService.getIssueKeyCode(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping(Constants.URL_GET_ISSUE_MECHANIC)
    public ApiResponse<IssueTypeMechanic> getIssueMechanic(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {

        return issueService.getIssueMechanic(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }
}
