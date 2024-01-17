package com.example.downtime.repositories;

import com.example.downtime.models.MachineWiseLostTimeModel;
import com.example.downtime.models.MainDownTimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MainDownTimeRepository extends JpaRepository<MainDownTimeModel, Integer> {

    @Query(value = "{CALL sp_main_down_time (?,?,?,?,?,?)}", nativeQuery = true)
    public List<MainDownTimeModel> getMainDownTime(
            @Param("pageSize") Integer pageSize,
            @Param("pageNum") Integer pageNum,
            @Param("facZone") String facZone,
            @Param("facLine") String facLine,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
}
