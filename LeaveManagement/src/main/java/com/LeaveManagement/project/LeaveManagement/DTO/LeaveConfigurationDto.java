package com.LeaveManagement.project.LeaveManagement.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class LeaveConfigurationDto {
    @JsonIgnore
    private int leaveConfigId;
    @JsonIgnore
    private int leavePeriodId;
    @JsonIgnore
    private int leaveTypeId;

    @JsonIgnore
    private int officeId = 1;
    @JsonIgnore
    private int leaveCount;
    @JsonIgnore
    private int activeStatus = 0;
    @JsonIgnore
    private int leavePerReq;


    public int getLeavePeriodId() {
        return leavePeriodId;
    }

    public void setLeavePeriodId(int leavePeriodId) {
        this.leavePeriodId = leavePeriodId;
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }


    public LeaveConfigurationDto() {
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

    public Date getFromLocalDate() {
        return fromLocalDate;
    }

    public void setFromLocalDate(Date fromLocalDate) {
        this.fromLocalDate = fromLocalDate;
    }

    public Date getToLocalDate() {
        return toLocalDate;
    }

    public void setToLocalDate(Date toLocalDate) {
        this.toLocalDate = toLocalDate;
    }

    public String getLeavePeriodName() {
        return leavePeriodName;
    }

    public void setLeavePeriodName(String leavePeriodName) {
        this.leavePeriodName = leavePeriodName;
    }

    public String getLeaveTypeDescription() {
        return leaveTypeDescription;
    }

    public void setLeaveTypeDescription(String leaveTypeDescription) {
        this.leaveTypeDescription = leaveTypeDescription;
    }

    public String getLeaveTypeShort() {
        return leaveTypeShort;
    }

    public void setLeaveTypeShort(String leaveTypeShort) {
        this.leaveTypeShort = leaveTypeShort;
    }

    public void setLeavePerReq(int leavePerReq) {
        this.leavePerReq = leavePerReq;
    }

    public int getLeaveConfigId() {
        return leaveConfigId;
    }

    public void setLeaveConfigId(int leaveConfigId) {
        this.leaveConfigId = leaveConfigId;
    }

    @Override
    public String toString() {
        return "LeaveConfigurationDto{" +
                "leavePeriodId=" + leavePeriodId +
                ", leaveTypeId=" + leaveTypeId +
                ", officeId=" + officeId +
                ", leaveCount=" + leaveCount +
                ", activeStatus=" + activeStatus +
                ", leavePerReq=" + leavePerReq +
                '}';
    }

    private Date fromLocalDate;
    private Date toLocalDate;
    private String leavePeriodName;
    private String leaveTypeDescription;
    private String leaveTypeShort;

    public LeaveConfigurationDto(Date fromLocalDate, Date toLocalDate, String leavePeriodName, String leaveTypeDescription, String leaveTypeShort) {
        this.fromLocalDate = fromLocalDate;
        this.toLocalDate = toLocalDate;
        this.leavePeriodName = leavePeriodName;
        this.leaveTypeDescription = leaveTypeDescription;
        this.leaveTypeShort = leaveTypeShort;
    }

}
