package com.example.downtime.service;

import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.IssueTypeMechanic;
import com.example.downtime.models.MachineBrokenModel;
import com.example.downtime.models.MachineWiseLostTimeModel;
import com.example.downtime.repositories.IssueTypeKeyCodeRepository;
import com.example.downtime.repositories.IssueTypeMechanicRepository;
import com.example.downtime.repositories.MachineBrokenRepository;
import com.example.downtime.repositories.WiseLostTimeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DownTimeService {

    private final WiseLostTimeRepository wiseLostTimeRepository;
    private final MachineBrokenRepository machineBrokenRepository;
    private final IssueTypeKeyCodeRepository issueTypeKeyCodeRepository;
    private final IssueTypeMechanicRepository issueTypeMechanicRepository;
    public List<MachineWiseLostTimeModel> getMachineWiseLostTime(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime
    ) {
        return wiseLostTimeRepository.getMachineWiseLostTime(pageSize, pageNum, facZone, facLine, startTime, endTime);
    }

    public List<MachineBrokenModel> getMachineBroken (int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime
    ) {
        return machineBrokenRepository.getMachineBroken(pageSize, pageNum, facZone, facLine, startTime, endTime);

    }

    public List<IssueTypeKeyCodeModel> getIssueKeyCode(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime) {
        return issueTypeKeyCodeRepository.getIssueTypeKeyCode(pageSize, pageNum, facZone, facLine, startTime, endTime);
    }


    public List<IssueTypeMechanic> getIssueMechanic(int pageSize, int pageNum, String facZone, String facLine
            , String startTime, String endTime) {
        return issueTypeMechanicRepository.getIssueTypeMechanic(pageSize, pageNum, facZone, facLine, startTime, endTime);
    }



}


