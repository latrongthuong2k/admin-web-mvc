package com.ra.serviceImp;

import com.ra.model.Category;
import com.ra.repository.CategoryRepository;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> displayData(String categoryNameSearch, int page, int size, String direction, String sortBy) {
        //Khởi tạo đối tượng Pageable
        Pageable pageable = PageRequest.of(page, size,
                direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
         return categoryRepository.findByCategoryName(categoryNameSearch, pageable);
    }

    @Override
    public int getListPage(String categoryName) {
        return categoryRepository.countByCategoryNameContains(categoryName);
    }

    @Override
    public Category findById(int categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int categoryId) {
        try {
            boolean isCheck = categoryRepository.isCheckProductId(categoryId);
            if (!isCheck) {
                categoryRepository.deleteById(categoryId);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }



    @Override
    public List<Category> findAllDataByCategoryStatusIsTrue() {
        return categoryRepository.findAllByCategoryStatusIsTrue();
    }


}
