package com.example.downtime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "fullname")
    private String mechanicName;

    @Column(name = "TotalLostTime")
    private Integer totalLostTime;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "AfectiveCode")
    private String keyCode;

    @JsonIgnore
    private Integer totalElements;
}
