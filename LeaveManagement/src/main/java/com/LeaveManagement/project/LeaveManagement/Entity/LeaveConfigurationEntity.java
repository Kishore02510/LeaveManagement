package com.LeaveManagement.project.LeaveManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "admin")
public class LeaveConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_config_seq")
    @SequenceGenerator(name = "leave_config_seq", sequenceName = "leave_config_sequence", allocationSize = 1)
    private int leaveConfigId;

    @ManyToOne
    @JoinColumn(name = "leavePeriodId",unique = false)
    private LeavePeriod leavePeriodId;

    @ManyToOne
    @JoinColumn(name = "leaveTypeId",unique = false)
    private LeaveType leaveTypeId;

    private int officeId = 1;

    private int leaveCount;

    private int activeStatus = 0;

    private int leavePerReq;

    public LeaveConfigurationEntity() {
    }

    public LeaveConfigurationEntity(int leaveConfigId, LeavePeriod leavePeriodId, LeaveType leaveTypeId, int officeId, int leaveCount, int activeStatus, int leavePerReq) {
        this.leaveConfigId = leaveConfigId;
        this.leavePeriodId = leavePeriodId;
        this.leaveTypeId = leaveTypeId;
        this.officeId = officeId;
        this.leaveCount = leaveCount;
        this.activeStatus = activeStatus;
        this.leavePerReq = leavePerReq;
    }

    public int getLeaveConfigId() {
        return leaveConfigId;
    }

    public void setLeaveConfigId(int leaveConfigId) {
        this.leaveConfigId = leaveConfigId;
    }

    public LeavePeriod getLeavePeriodId() {
        return leavePeriodId;
    }

    public void setLeavePeriodId(LeavePeriod leavePeriodId) {
        this.leavePeriodId = leavePeriodId;
    }

    public LeaveType getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(LeaveType leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getLeaveCount() {
        return leaveCount;
    }

    public void setLeaveCount(int leaveCount) {
        this.leaveCount = leaveCount;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getLeavePerReq() {
        return leavePerReq;
    }

    public void setLeavePerReq(int leavePerReq) {
        this.leavePerReq = leavePerReq;
    }
}
