package com.ra.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accId;

    @NotBlank
    @Column(name = "email",length = 100)
    private String email;

    @NotBlank
    @Column(name = "password",length = 30)
    private String password;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date created;


    @Column(name = "role")
    private boolean role=false;

    @Column(name = "acc_status")
    private boolean accStatus=true;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    private List<Bill> listBill;

    public Account() {
    }

    public Account(int accId, String email, String password, Date created,
                   boolean role, boolean accStatus, List<Bill> listBill) {
        this.accId = accId;
        this.email = email;
        this.password = password;
        this.created = created;
        this.role = role;
        this.accStatus = accStatus;
        this.listBill = listBill;
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

    public List<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(List<Bill> listBill) {
        this.listBill = listBill;
    }
}
