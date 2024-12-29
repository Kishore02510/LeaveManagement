package com.LeaveManagement.project.LeaveManagement.Service;

import com.LeaveManagement.project.LeaveManagement.Entity.LeavePeriod;
import com.LeaveManagement.project.LeaveManagement.Repository.LeavePeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LeavePeriodService {
    @Autowired
    private LeavePeriodRepository lpr;

    public ResponseEntity<String> addLeavePeriod(LeavePeriod leavePeriod){
        lpr.save(leavePeriod);
        return new ResponseEntity<>("Leave Period Saved Successufully...", HttpStatus.CREATED);
    }
    public List<LeavePeriod> funView(){
        return lpr.findAll();
    }
    public LeavePeriod funGetById(int id){
//        LeavePeriod lp = new LeavePeriod();
//        lp.setLeavePeriodId(leavePeriod.getLeavePeriodId());
        //return lr.getById(id);
        return lpr.findById(id)
                .orElseThrow(() -> new RuntimeException("LeavePeriod not found with id: " + id));
    }

    public ResponseEntity<String> funDelete(){
      lpr.deleteAll();
      return new ResponseEntity<>("Deleted Successfully",HttpStatus.CREATED);
    }

    public ResponseEntity<String>  funUpdate(int lpId,LeavePeriod leavePeriod){
        LeavePeriod lp = lpr.findById(lpId).orElseThrow();
        lp.setLeavePeriodName(leavePeriod.getLeavePeriodName());
        lp.setToDate(leavePeriod.getToDate());
        lp.setFromDate(leavePeriod.getFromDate());
        lp.setActiveStatus(leavePeriod.getActiveStatus());
        lpr.save(lp);
        return new ResponseEntity<>("Leave Period Updated Successufully...", HttpStatus.CREATED);
    }
}
