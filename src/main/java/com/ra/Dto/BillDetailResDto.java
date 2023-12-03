package com.ra.Dto;
public class BillDetailResDto {
    private Long billDetailId;
    private float price;
    private Long quantity;
    private Double total;
    public BillDetailResDto() {
    }

    public BillDetailResDto(Long billDetailId, float price, Long quantity, Double total) {
        this.billDetailId = billDetailId;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
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
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

