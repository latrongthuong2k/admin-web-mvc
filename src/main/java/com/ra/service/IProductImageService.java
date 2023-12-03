package com.ra.service;

import com.ra.model.ImageProduct;

import java.util.List;

public interface IProductImageService {
    List<ImageProduct> findAllDataByProduct_ProductId(Integer productId);
}
