package com.example.downtime.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MachineWiseLostTimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowNum;

    @Column(name = "McType")
    private String mcType;

    @Column(name = "Total")
    private int total;

    @JsonIgnore
    private Integer totalElements;

}
