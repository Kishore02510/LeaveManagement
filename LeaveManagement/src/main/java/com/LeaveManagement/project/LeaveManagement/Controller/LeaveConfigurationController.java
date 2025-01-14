package com.LeaveManagement.project.LeaveManagement.Controller;

import com.LeaveManagement.project.LeaveManagement.DTO.LeaveConfigurationDto;
import com.LeaveManagement.project.LeaveManagement.Entity.LeaveConfigurationEntity;
import com.LeaveManagement.project.LeaveManagement.Entity.LeavePeriod;
import com.LeaveManagement.project.LeaveManagement.Entity.LeaveType;
import com.LeaveManagement.project.LeaveManagement.Repository.LeaveConfigurationRepository;
import com.LeaveManagement.project.LeaveManagement.Repository.LeavePeriodRepository;
import com.LeaveManagement.project.LeaveManagement.Repository.LeaveTypeRepository;
import com.LeaveManagement.project.LeaveManagement.Service.LeaveConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/leaveconfigurationcontroller")
public class LeaveConfigurationController {

    @Autowired
    private LeaveConfigurationService lcs;

    @Autowired
    private LeavePeriodRepository lpr;
    @Autowired
    private LeaveTypeRepository ltr;

    @PostMapping("/saveLeaveConfiguration")
    public ResponseEntity<String> addLeaveConfiguration(@RequestBody LeaveConfigurationDto leaveConfigDto) {
        System.out.println(leaveConfigDto);

        LeavePeriod leavePeriod = lpr.findById(leaveConfigDto.getLeavePeriodId()).orElseThrow(() ->new RuntimeException("LeavePeriod not found with ID " + leaveConfigDto.getLeaveTypeId()));
        LeaveType leaveTyp = ltr.findById(leaveConfigDto.getLeaveTypeId()).orElseThrow(() ->new RuntimeException("LeaveType not found with ID " + leaveConfigDto.getLeaveTypeId()));

        LeaveConfigurationEntity lce = new LeaveConfigurationEntity();
        lce.setLeavePeriodId(leavePeriod);
        lce.setLeaveTypeId(leaveTyp);
        lce.setLeaveCount(leaveConfigDto.getLeaveCount());
        lce.setLeavePerReq(leaveConfigDto.getLeavePerReq());
        return lcs.addLeaveConfig(lce);
    }

    @GetMapping("/viewLeaveConfiguration")
    public ResponseEntity<List<LeaveConfigurationDto>> funView() {
        return lcs.funView();
    }

    @PutMapping("/updateLeaveConfiguration/{id}")
    public ResponseEntity<String> funUpdate(@PathVariable int id, @RequestBody LeaveConfigurationDto leaveConfigurationDto) {
        return lcs.funUpdate(id, leaveConfigurationDto);
    }

    @DeleteMapping("/deleteLeaveConfig/{id}")
    public ResponseEntity<String> funDelete(@PathVariable int id) {
        return lcs.funDelete(id);
    }

}
