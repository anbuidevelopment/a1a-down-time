package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "DowntimeCode")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "DowntimeCode")
@NamedStoredProcedureQuery(name = "DowntimeCode.sp_dtcode",procedureName = "sp_dtcode")
public class DowntimeCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DTCode;
    private String AfectiveCode;
    private String McType;
    private String Reason;
    private String McGroup;
    private Date SysDate;
}
