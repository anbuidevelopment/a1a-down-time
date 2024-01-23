package com.example.downtime.repositories;

import com.example.downtime.models.FactoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FactoryRepository extends JpaRepository<FactoryModel, String> {

    @Query (value= "{CALL sp_fac}", nativeQuery = true)
    public List<FactoryModel> getFac ();

}
