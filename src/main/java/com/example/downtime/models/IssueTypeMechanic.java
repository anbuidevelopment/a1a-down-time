package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IssueTypeMechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowNum;

    @Column(name = "Mechanic")
    private String mechanicCode;

    @Column(name = "TotalLostTime")
    private Integer totalLostTime;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "AfectiveCode")
    private String keyCode;

}
