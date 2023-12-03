package com.ra.repository;

import com.ra.model.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ImageProduct,Integer> {

    @Query("select ip from ImageProduct ip where ip.product.productId =:productId")
    List<ImageProduct> findAllDataByProduct_ProductId(@Param("productId") Integer productId);
}
