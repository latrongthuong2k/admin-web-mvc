package com.ra.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private Date created;
    @Column(name = "bill_status")
    private int billStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
    private Account account;

    @OneToMany(mappedBy = "bill",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<BillDetail> listBillDetail;

    public Bill() {
    }

    public Bill(Integer billId, Date created, int billStatus, Account account, List<BillDetail> listBillDetail) {
        this.billId = billId;
        this.created = created;
        this.billStatus = billStatus;
        this.account = account;
        this.listBillDetail = listBillDetail;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<BillDetail> getListBillDetail() {
        return listBillDetail;
    }

    public void setListBillDetail(List<BillDetail> listBillDetail) {
        this.listBillDetail = listBillDetail;
    }
}
