package com.example.downtime.controllers;

import com.example.downtime.ApiResponse.ApiResponse;
import com.example.downtime.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IssueController extends Controller {

    private final IssueService issueService;

    @GetMapping("/get-issue-keycode")
    public ApiResponse getIssueKeyCode(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {
        return issueService.getIssueKeyCode(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }

    @GetMapping(value = "/get-issue-mechanic")
    public ApiResponse getIssueMechanic(@RequestParam("s") Integer pageSize, @RequestParam("p") Integer pageNumber, @RequestParam(value = "f", required = false, defaultValue = "") String facZone, @RequestParam(value = "l", required = false, defaultValue = "") String facLine, @RequestParam(value = "start", required = false) String startTime, @RequestParam(value = "end", required = false) String endTime) {

        return issueService.getIssueMechanic(facZone, facLine, startTime, endTime, pageNumber, pageSize);
    }
}
