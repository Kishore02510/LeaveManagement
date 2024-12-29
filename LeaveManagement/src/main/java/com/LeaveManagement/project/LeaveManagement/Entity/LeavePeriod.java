package com.LeaveManagement.project.LeaveManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Builder
@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class LeavePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leavePeriodId;
    private String leavePeriodName;
    private Date fromDate;
    private Date toDate;
    //@Builder.Default
    private int activeStatus=0;

    public int getLeavePeriodId() {
        return leavePeriodId;
    }

    public void setLeavePeriodId(int leavePeriodId) {
        this.leavePeriodId = leavePeriodId;
    }

    public String getLeavePeriodName() {
        return leavePeriodName;
    }

    public void setLeavePeriodName(String leavePeriodName) {
        this.leavePeriodName = leavePeriodName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "LeavePeriod{" +
                "leavePeriodId=" + leavePeriodId +
                ", leavePeriodName='" + leavePeriodName + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
