package com.ra.serviceImp;

import com.ra.model.ImageProduct;
import com.ra.repository.ProductImageRepository;
import com.ra.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImp implements IProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<ImageProduct> findAllDataByProduct_ProductId(Integer productId) {
        return productImageRepository.findAllDataByProduct_ProductId(productId);
    }
}
