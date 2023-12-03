package com.ra.service;

import com.ra.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Page<Category> displayData(String categoryNameSearch, int page, int size, String direction, String sortBy);

    //    List<Category> findAllDataByCategoryIdAndCategoryName();
    List<Category> findAllDataByCategoryStatusIsTrue();

    int getListPage(String categoryName);

    Category findById(int categoryId);


    boolean saveOrUpdate(Category category);

    boolean delete(int categoryId);


}
