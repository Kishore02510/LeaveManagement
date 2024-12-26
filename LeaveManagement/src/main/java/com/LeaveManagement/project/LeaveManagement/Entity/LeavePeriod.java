package com.LeaveManagement.project.LeaveManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeavePeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leavePeriodId;
    private String leavePeriodName;
    private Date fromDate;
    private Date toDate;
    private int activeStatus=0;

}
