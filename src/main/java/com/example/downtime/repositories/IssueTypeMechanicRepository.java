package com.example.downtime.repositories;

import com.example.downtime.models.IssueTypeMechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueTypeMechanicRepository extends JpaRepository<IssueTypeMechanic, Integer>     {

    @Query(value = "{CALL sp_kind_of_issue2 (?,?,?,?,?,?)}", nativeQuery = true)
    public List<IssueTypeMechanic> getIssueTypeMechanic(
            @Param("pageSize") Integer pageSize,
            @Param("pageNum") Integer pageNum,
            @Param("facZone") String facZone,
            @Param("facLine") String facLine,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime
    );
}
