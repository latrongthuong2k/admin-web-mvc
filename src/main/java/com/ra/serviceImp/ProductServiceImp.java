package com.ra.serviceImp;

import com.ra.model.Product;
import com.ra.repository.ProductRepository;
import com.ra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> displayData(String searchTerm, int page, int size, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(page, size,
                direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return productRepository.searchByNameAndTitleAndPrice(searchTerm, pageable);
    }

    @Override
    public int getListPage(String productSearch) {
        return productRepository.countByProductIdContains(productSearch);
    }

    @Override
    public Product findByProductId(Integer productId) {
        return productRepository.findByProductId(productId);
    }

    @Override
    public void save(Product product) {
        try {
            productRepository.save(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean update(Product productEdit, Product productOriginal) {
        if (productEdit.getImage() != null) {
            productOriginal.setImage(productEdit.getImage());
            productOriginal.setProductImageName(productEdit.getProductImageName());
        }
        productOriginal.setProductName(productEdit.getProductName());
        productOriginal.setPrice(productEdit.getPrice());
        productOriginal.setTittle(productEdit.getTittle());
        productOriginal.setProductDescription(productEdit.getProductDescription());
        productOriginal.setProductStatus(productEdit.isProductStatus());
        productOriginal.setProductUnit(productEdit.getProductUnit());
        try {
            productRepository.save(productOriginal);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Product product) {
        try {
            productRepository.delete(product);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> getAllData() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllDataByProductStatusIsTrue() {
        return productRepository.findAllByProductStatusIsTrue();
    }


    @Override
    public int statisticalProductActive() {
        return productRepository.statisticalProductActive();
    }

    @Override
    public int statisticalProductInActive() {
        return productRepository.statisticalProductInActive();
    }
}
