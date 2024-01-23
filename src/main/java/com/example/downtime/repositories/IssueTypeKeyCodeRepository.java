package com.example.downtime.repositories;


import com.example.downtime.models.IssueTypeKeyCodeModel;
import com.example.downtime.models.MachineBrokenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssueTypeKeyCodeRepository extends JpaRepository<IssueTypeKeyCodeModel, Integer> {

    @Query(value = "{CALL usp_kind_of_issue (?,?,?,?,?,?)}", nativeQuery = true)
    public List<IssueTypeKeyCodeModel> getIssueTypeKeyCode (
            @Param("facZone") String facZone,
            @Param("facLine") String facLine,
            @Param("startTime") String startTime,
            @Param("endTime") String endTime,
            @Param("pageNum") Integer pageNum,
            @Param("pageSize") Integer pageSize
    );
}
