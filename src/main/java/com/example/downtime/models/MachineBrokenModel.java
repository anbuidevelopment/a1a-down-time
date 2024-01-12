package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MachineBrokenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowNum;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "LostTime")
    private int lostTime;

    @Column(name = "McSerialNo")
    private String serialNumber;

    @Column(name = "AfectiveCode")
    private String keyCode;

    @Column(name= "Reason")
    private String descriptionBroken;

}
