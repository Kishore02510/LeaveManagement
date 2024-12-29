package com.LeaveManagement.project.LeaveManagement.Service;

import com.LeaveManagement.project.LeaveManagement.Entity.LeaveType;
import com.LeaveManagement.project.LeaveManagement.Repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveTypeService {

    @Autowired
    LeaveTypeRepository repo;
    public ResponseEntity<String> saveLeaveType(LeaveType leaveType) {
      repo.save(leaveType);
      return new ResponseEntity<>("LeaveType succesfully created", HttpStatus.CREATED);
    }



    public ResponseEntity<String> updateLeaveType(int id, LeaveType leaveType) {
        LeaveType LT = repo.findById(id).orElseThrow();
        LT.setLeaveTypeDescription(leaveType.getLeaveTypeDescription());
        LT.setLeaveTypeShort(leaveType.getLeaveTypeShort());
        repo.save(LT);
        return new ResponseEntity<>("Updated Succesfully!",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> deleteLeaveTypeId(int id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Deleted Succesfully!",HttpStatus.OK);
    }

    public ResponseEntity<List<LeaveType>> getLeaveType() {
        return new ResponseEntity<>(repo.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<LeaveType> getLeaveTypeById(int id) {
        Optional<LeaveType> leaveType = repo.findById(id);
        if (leaveType.isPresent()) {
            return new ResponseEntity<>(leaveType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
