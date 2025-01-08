package com.LeaveManagement.project.LeaveManagement.Entity;

import jakarta.persistence.*;
import org.springframework.lang.Nullable;

import javax.xml.validation.Schema;

@Table(schema = "admin")
@Entity
public class LeaveType {

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeShort() {
        return leaveTypeShort;
    }

    public LeaveType() {
    }

    public void setLeaveTypeShort(String leaveTypeShort) {
        this.leaveTypeShort = leaveTypeShort;
    }

    public String getLeaveTypeDescription() {
        return leaveTypeDescription;
    }

    public void setLeaveTypeDescription(String leaveTypeDescription) {
        this.leaveTypeDescription = leaveTypeDescription;
    }

    public byte getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(byte activeStatus) {
        this.activeStatus = activeStatus;
    }

    public LeaveType(int leaveTypeId, String leaveTypeShort, String leaveTypeDescription, byte activeStatus) {
        this.leaveTypeId = leaveTypeId;
        this.leaveTypeShort = leaveTypeShort;
        this.leaveTypeDescription = leaveTypeDescription;
        this.activeStatus = activeStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveTypeId;

    @Column(nullable = false,unique = true)
    private String leaveTypeShort;
    @Column(nullable = false,unique = true)
    private String leaveTypeDescription;

    private byte activeStatus = 0;

}
