package com.example.downtime.repositories;

import com.example.downtime.models.DowntimeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DowntimeCodeRepository extends JpaRepository<DowntimeCode, Integer> {
}
