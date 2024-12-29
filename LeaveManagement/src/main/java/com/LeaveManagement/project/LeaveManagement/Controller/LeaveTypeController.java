package com.LeaveManagement.project.LeaveManagement.Controller;

import com.LeaveManagement.project.LeaveManagement.Entity.LeaveType;
import com.LeaveManagement.project.LeaveManagement.Service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/LeaveTypeMaster")
public class LeaveTypeController {

    @Autowired
    LeaveTypeService service;
    @PostMapping("saveLeaveType")
    public ResponseEntity<String> saveLeaveType(@RequestBody LeaveType leaveType){
        return service.saveLeaveType(leaveType);
    }
    @GetMapping("getLeaveType")
    public ResponseEntity<List<LeaveType>> getLeaveType(){
        return service.getLeaveType();
    }

    @GetMapping("getLeaveTypeById/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById( @PathVariable int id){
        return service.getLeaveTypeById(id);
    }
    @PutMapping("updateLeaveTypeById/{id}")
    public ResponseEntity<String> updateLeaveType(@PathVariable int id,@RequestBody LeaveType leaveType){
        return service.updateLeaveType(id,leaveType);
    }

    @DeleteMapping("deleteLeaveTypeById/{id}")
    public ResponseEntity<String> deleteLeaveTypeId(@PathVariable int id){
        return service.deleteLeaveTypeId(id);
    }

}
