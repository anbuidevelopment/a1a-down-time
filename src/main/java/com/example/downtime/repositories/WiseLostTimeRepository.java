package com.example.downtime.repositories;

import com.example.downtime.models.MachineWiseLostTimeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WiseLostTimeRepository extends JpaRepository<MachineWiseLostTimeModel, String> {

    @Query(value = "{CALL usp_machine_wise_lost_time (?,?,?,?,?,?)}", nativeQuery = true)
    public List<MachineWiseLostTimeModel> getMachineWiseLostTime(
            @Param("facZone") String facZone,
            @Param("facLine") String facLine,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize
    );

}
