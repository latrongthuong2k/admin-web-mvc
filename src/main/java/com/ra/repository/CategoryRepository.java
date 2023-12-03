package com.ra.repository;

import com.ra.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select ca from Category ca where ca.categoryName like %?1%")
    Page<Category> findByCategoryName(String categoryNameSearch, Pageable pageable);
    int countByCategoryNameContains(String categoryName);
    List<Category> findAllByCategoryStatusIsTrue();


    @Query("SELECT COUNT(pr.productId) >= 1 FROM Product pr WHERE pr.category.categoryId = :categoryId")
    boolean isCheckProductId(@Param("categoryId") int categoryId);


}
