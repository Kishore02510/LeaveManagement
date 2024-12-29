package com.LeaveManagement.project.LeaveManagement.Repository;

import com.LeaveManagement.project.LeaveManagement.Entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType,Integer> {
}
