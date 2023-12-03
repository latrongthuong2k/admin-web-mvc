package com.ra.service;

import com.ra.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    Page<Product> displayData(String searchTerm, int page, int size, String direction, String sortBy);
    int getListPage(String productSearch);
    Product findByProductId(Integer productId);

    void save(Product product);
    boolean update(Product productEdit, Product productOriginal);

    boolean delete(Product product);

    List<Product> getAllData();
    List<Product> getAllDataByProductStatusIsTrue();
    int statisticalProductActive();
    int statisticalProductInActive();


    
}
