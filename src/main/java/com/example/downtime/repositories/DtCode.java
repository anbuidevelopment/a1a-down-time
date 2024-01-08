package com.example.downtime.repositories;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DtCode{
    @Autowired
    private EntityManager em;

    public List<DtCode> getDtCode() {
        return em.createNamedStoredProcedureQuery("first").getResultList();
    }
}
