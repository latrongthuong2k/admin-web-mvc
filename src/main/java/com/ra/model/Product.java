package com.ra.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id" )
    private Integer productId;

    @Column(name = "product_name", unique = true, length = 150)
    private String productName;

    @NotBlank
    @Positive
    @Column(name = "price")
    private float price;

    @Lob
    @Column(columnDefinition = "TEXT", name = "tittle")
    private String tittle;

    @Lob
    @Column(columnDefinition = "TEXT", name = "product_description")
    private String productDescription;

    @NotBlank
    @Lob
    @Column(columnDefinition = "TEXT", name = "product_image")
    private String image;


    @Column(name = "product_unit")
    private int productUnit;

    @Column(name = "product_status")
    private boolean productStatus;

    @Column(columnDefinition = "TEXT",name = "product_image_name")
    private String productImageName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;


    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ImageProduct> listImageProduct;

    @OneToMany(mappedBy = "productT2",fetch = FetchType.EAGER)
    private List<BillDetail> listBillDetail;

    public Product() {
    }

    public Product(Integer productId, String productName, float price, String tittle,
                   String productDescription, String image, int productUnit, boolean productStatus,
                   String productImageName, Category category, List<ImageProduct> listImageProduct,
                   List<BillDetail> listBillDetail) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.tittle = tittle;
        this.productDescription = productDescription;
        this.image = image;
        this.productUnit = productUnit;
        this.productStatus = productStatus;
        this.productImageName = productImageName;
        this.category = category;
        this.listImageProduct = listImageProduct;
        this.listBillDetail = listBillDetail;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ImageProduct> getListImageProduct() {
        return listImageProduct;
    }

    public void setListImageProduct(List<ImageProduct> listImageProduct) {
        this.listImageProduct = listImageProduct;
    }

    public List<BillDetail> getListBillDetail() {
        return listBillDetail;
    }

    public void setListBillDetail(List<BillDetail> listBillDetail) {
        this.listBillDetail = listBillDetail;
    }

    public String getProductImageName() {
        return productImageName;
    }

    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }
}
