package com.LeaveManagement.project.LeaveManagement.Service;

import com.LeaveManagement.project.LeaveManagement.DTO.LeaveConfigurationDto;
import com.LeaveManagement.project.LeaveManagement.Entity.LeaveConfigurationEntity;
import com.LeaveManagement.project.LeaveManagement.Entity.LeavePeriod;
import com.LeaveManagement.project.LeaveManagement.Entity.LeaveType;
import com.LeaveManagement.project.LeaveManagement.Repository.LeaveConfigurationRepository;
import com.LeaveManagement.project.LeaveManagement.Repository.LeavePeriodRepository;
import com.LeaveManagement.project.LeaveManagement.Repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveConfigurationService {

    @Autowired
    private LeaveConfigurationRepository lcr;
    @Autowired
    private LeaveTypeRepository ltr;
    @Autowired
    private LeavePeriodRepository lpr;

    public ResponseEntity<String> addLeaveConfig(LeaveConfigurationEntity leaveConfigEntity) {
        lcr.save(leaveConfigEntity);
        return new ResponseEntity<>("Leave Configuration Saved Successfully...", HttpStatus.CREATED);
    }

    public ResponseEntity<List<LeaveConfigurationDto>> funView() {
        return new ResponseEntity<>(lcr.funView(), HttpStatus.OK);
    }

    public ResponseEntity<String> funUpdate(int id, LeaveConfigurationDto leaveConfigurationDto) {
        LeaveConfigurationEntity leaveConfigurationEntity = lcr.findById(id)
                .orElseThrow(() -> new RuntimeException("LeaveConfiguration not found with ID " + id));

        leaveConfigurationEntity.setLeaveCount(leaveConfigurationDto.getLeaveCount());
        leaveConfigurationEntity.setLeavePerReq(leaveConfigurationDto.getLeavePerReq());
        leaveConfigurationEntity.setActiveStatus(leaveConfigurationDto.getActiveStatus());
        leaveConfigurationEntity.setOfficeId(leaveConfigurationDto.getOfficeId());

        LeaveType lt = ltr.findById(leaveConfigurationDto.getLeaveTypeId()).orElseThrow(() -> new RuntimeException("LeaveType not found with ID " + id));
        LeavePeriod lp = lpr.findById(leaveConfigurationDto.getLeavePeriodId()).orElseThrow(() -> new RuntimeException("LeavePeriod not found with ID " + id));

        leaveConfigurationEntity.setLeaveTypeId(lt);
        leaveConfigurationEntity.setLeavePeriodId(lp);
        LeaveConfigurationEntity updatedLeaveConfig = lcr.save(leaveConfigurationEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Leave Configuration updated successfully with ID: " + updatedLeaveConfig.getLeaveConfigId());

    }

    public ResponseEntity<String> funDelete(int id) {
        LeaveConfigurationEntity leaveConfigurationEntity = lcr.findById(id)
                .orElseThrow(() -> new RuntimeException("LeaveConfiguration not found with ID " + id));
        lcr.delete(leaveConfigurationEntity);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Leave Configuration deleted successfully with ID: " + id);
    }

}
