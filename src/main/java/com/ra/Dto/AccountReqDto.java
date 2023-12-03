package com.ra.Dto;

import java.util.Date;

public class AccountReqDto {
    private int accId;

    private String email;
    private String password;

    private Date created;
    private boolean role;
    private boolean accStatus;

    public AccountReqDto() {
    }

    public AccountReqDto(int accId, String email, String password, Date created, boolean role, boolean accStatus) {
        this.accId = accId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.role = role;
        this.accStatus = accStatus;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isAccStatus() {
        return accStatus;
    }

    public void setAccStatus(boolean accStatus) {
        this.accStatus = accStatus;
    }
}
