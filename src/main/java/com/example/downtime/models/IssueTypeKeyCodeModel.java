package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IssueTypeKeyCodeModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rowNum;

    @Column(name = "AfectiveCode")
    private String keyCode;

    @Column(name = "Reason")
    private String descriptionBroken;

    @Column(name = "LostTime")
    private Integer lostTime;

}
