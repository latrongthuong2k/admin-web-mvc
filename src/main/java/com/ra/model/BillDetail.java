package com.ra.model;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Entity
@Table(name = "BillDetail")
public class BillDetail {
    @Id
    @Column(name = "bill_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billDetailId;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "total", columnDefinition = "DOUBLE")
    @Formula("price * quantity")
    private Double total;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product productT2;

    public BillDetail() {
    }

    public BillDetail(Long billDetailId, float price, Long quantity, Double total, Bill bill, Product productT2) {
        this.billDetailId = billDetailId;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.bill = bill;
        this.productT2 = productT2;
    }

    public Long getBillDetailId() {
        return billDetailId;
    }

    public void setBillDetailId(Long billDetailId) {
        this.billDetailId = billDetailId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total != null ? Math.round(total * 10) / 10.0 : null;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getProductT2() {
        return productT2;
    }

    public void setProductT2(Product productT2) {
        this.productT2 = productT2;
    }
}
