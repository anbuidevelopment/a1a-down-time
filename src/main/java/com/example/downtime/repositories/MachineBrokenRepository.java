package com.example.downtime.repositories;

import com.example.downtime.models.MachineBrokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MachineBrokenRepository extends JpaRepository<MachineBrokenModel, Integer> {

    @Query(value = "{CALL usp_machine_broken (?,?,?,?,?,?)}", nativeQuery = true)
    public List<MachineBrokenModel> getMachineBroken (
            @Param("facZone") String facZone,
            @Param("facLine") String facLine,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize
    );
}
