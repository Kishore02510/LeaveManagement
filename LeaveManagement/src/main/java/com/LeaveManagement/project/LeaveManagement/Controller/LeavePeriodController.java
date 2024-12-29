package com.LeaveManagement.project.LeaveManagement.Controller;

import com.LeaveManagement.project.LeaveManagement.Entity.LeavePeriod;
import com.LeaveManagement.project.LeaveManagement.Service.LeavePeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin/leaveperiodmaster")
public class LeavePeriodController {

    @Autowired
    private LeavePeriodService lps;
    @PostMapping("/addleaveperiod")
    public ResponseEntity<String> funSave(@RequestBody LeavePeriod leavePeriod){
        System.out.println(leavePeriod);
        return lps.addLeavePeriod(leavePeriod);
    }

    @GetMapping("/getView")
    public ResponseEntity<List<LeavePeriod>> funView(){
        return ResponseEntity.ok(lps.funView());
    }

    @GetMapping("/getBYId/{id}")
    public ResponseEntity<LeavePeriod> getLeavePeriodById(@PathVariable int id) {
        LeavePeriod leavePeriod = lps.funGetById(id);
        return ResponseEntity.ok(leavePeriod);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> funDelete(){
        return lps.funDelete();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> funDeleteById(@PathVariable int id){
        return lps.funDeleteById(id);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<String> funUpdate(@PathVariable("id") int id,@RequestBody LeavePeriod leavePeriod){
        return lps.funUpdate(id, leavePeriod);
    }
}

