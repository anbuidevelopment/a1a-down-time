package com.example.downtime.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NamedStoredProcedureQuery(name = "first", procedureName = "sp_dtcode")
public class DtCode {
    @Id
    private int id;
    private String McType;
}
