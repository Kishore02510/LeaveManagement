package com.LeaveManagement.project.LeaveManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
//@Builder
@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(schema = "admin")
public class LeavePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leavePeriodId;
    private String leavePeriodName;
    private LocalDate fromLocalDate;
    private LocalDate toLocalDate;
    //@Builder.Default
    private int activeStatus=0;

    public LeavePeriod() {
    }


    public int getLeavePeriodId() {return leavePeriodId;}

    public void setLeavePeriodId(int leavePeriodId) {
        this.leavePeriodId = leavePeriodId;
    }

    public String getLeavePeriodName() {
        return leavePeriodName;
    }

    public void setLeavePeriodName(String leavePeriodName) {
        this.leavePeriodName = leavePeriodName;
    }

    public LocalDate getFromDate() {
        return fromLocalDate;
    }

    public void setFromDate(LocalDate fromLocalDate) {
        this.fromLocalDate = fromLocalDate;
    }

    public LocalDate getToDate() {
        return toLocalDate;
    }

    public void setToDate(LocalDate toLocalDate) {
        this.toLocalDate = toLocalDate;
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
                ", fromLocalDate=" + fromLocalDate +
                ", toLocalDate=" + toLocalDate +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
