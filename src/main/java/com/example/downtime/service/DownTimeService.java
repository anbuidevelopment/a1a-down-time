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

    private final MainDownTimeRepository mainDownTimeRepository;
    private final FactoryRepository factoryRepository;

    private final Util util;






}


