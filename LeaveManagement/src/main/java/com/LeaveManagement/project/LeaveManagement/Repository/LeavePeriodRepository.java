package com.LeaveManagement.project.LeaveManagement.Repository;

import com.LeaveManagement.project.LeaveManagement.Entity.LeavePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavePeriodRepository extends JpaRepository<LeavePeriod,Integer> {
}