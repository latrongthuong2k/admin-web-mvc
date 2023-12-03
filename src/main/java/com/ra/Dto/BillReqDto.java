package com.ra.Dto;

import java.util.Date;

public class BillReqDto {
    private Integer billId;
    private Date created;
    private int billStatus;
    private int accId;

    public BillReqDto() {
    }

    public BillReqDto(Integer billId, Date created, int billStatus, int accId) {
        this.billId = billId;
        this.created = created;
        this.billStatus = billStatus;
        this.accId = accId;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }
}
