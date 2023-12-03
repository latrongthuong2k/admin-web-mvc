package com.ra.Dto;

public class ProductResDto {
    private Integer productId;
    private String productName;
    private float price;
    private String tittle;
    private String productDescription;

    private String image;

    private int productUnit;

    private boolean productStatus;

    private String productImageName;

    private String categoryName;
    private int categoryId;
    public ProductResDto() {
    }

    public ProductResDto(Integer productId, String productName, float price, String tittle, String productDescription,
                         String image, int productUnit, boolean productStatus, String productImageName,
                         String categoryName, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.tittle = tittle;
        this.productDescription = productDescription;
        this.image = image;
        this.productUnit = productUnit;
        this.productStatus = productStatus;
        this.productImageName = productImageName;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(int productUnit) {
        this.productUnit = productUnit;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}