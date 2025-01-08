package com.LeaveManagement.project.LeaveManagement.Repository;

import com.LeaveManagement.project.LeaveManagement.DTO.LeaveConfigurationDto;
import com.LeaveManagement.project.LeaveManagement.Entity.LeaveConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveConfigurationRepository extends JpaRepository<LeaveConfigurationEntity, Integer> {

    @Query(value = "SELECT lp.from_local_date, lp.to_local_date, lp.leave_period_name, " +
            "lt.leave_type_description, lt.leave_type_short " +
            "FROM admin.leave_configuration_entity lce " +
            "JOIN admin.leave_period lp ON lp.leave_period_id = lce.leave_period_id " +
            "JOIN admin.leave_type lt ON lt.leave_type_id = lce.leave_type_id " +
            "ORDER BY lce.leave_config_id", nativeQuery = true)
    List<LeaveConfigurationDto> funView();


}
