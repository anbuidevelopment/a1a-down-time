package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FactoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowNum;

    @Column(name = "facLine")
    private String facLine;

    @Column(name = "facZone")
    private String facZone;

}
