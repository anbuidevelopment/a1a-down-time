package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "DowntimeCode")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "DowntimeCode")
public class DowntimeCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DTCode")
    private Integer DTCode;

    @Column(name = "AfectiveCode")
    private String AfectiveCode;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "McGroup")
    private String mcGroup;

    @Column(name = "SysDate")
    private Date sysDate;
}
