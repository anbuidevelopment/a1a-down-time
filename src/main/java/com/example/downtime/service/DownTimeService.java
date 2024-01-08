package com.example.downtime.service;

import com.example.downtime.models.DowntimeCode;
import com.example.downtime.repositories.DowntimeCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DownTimeService {
    private final DowntimeCodeRepository repository;

    public List<DowntimeCode> getMcType() {
        return repository.findAll();
    }
}
