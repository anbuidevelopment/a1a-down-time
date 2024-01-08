package com.example.downtime.controllers;

import com.example.downtime.repositories.DtCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Downtime")
@RequiredArgsConstructor
public class DowntimeController {

    @Autowired
    private DtCode dtCode;



    @GetMapping("/abc")
    public List<String> getString() {
        return List.of("ban", "nabc");
    }
    @GetMapping("")
    public List<DtCode> getDtCode() {
        return dtCode.getDtCode();
    }
}
