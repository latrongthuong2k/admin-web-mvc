package com.ra.repository;

import com.ra.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1% OR p.tittle LIKE %?1% OR CAST(p.price AS string) LIKE %?1%")
    Page<Product> searchByNameAndTitleAndPrice(String search, Pageable pageable);

    @Query("select count(pr.productId) from Product pr where pr.productName like %?1% or pr.tittle like %?1%")
    int countByProductIdContains(String productSearch);

    @Query("SELECT pr FROM Product pr WHERE pr.productId = :productId")
    Product findByProductId(@Param("productId") Integer productId);

    List<Product> findAllByProductStatusIsTrue();

    @Query("SELECT COUNT(pr) FROM Product pr WHERE pr.productStatus = true")
    int statisticalProductActive();

    @Query("SELECT COUNT(pr) FROM Product pr WHERE pr.productStatus = false")
    int statisticalProductInActive();

}
