package com.example.downtime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainDownTimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String rowNum;

    @Column(name = "OccurTime")
    private Date Date;

    @Column(name = "McSerialNo")
    private String serialNumber;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "FacLine")
    private String location;

    @Column(name = "AfectiveCode")
    private String issue;

    @Column(name = "Status")
    private String status;

    @Column(name = "Mechanic")
    private String mechanicFix;

    @Column(name = "LostTime")
    private Integer totalLostTime;

    @JsonIgnore
    private Integer totalElements;

}
