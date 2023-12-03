package com.ra.controller;

import com.google.gson.Gson;
import com.ra.Dto.CategoryReqDto;
import com.ra.model.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private static final int size = 5;
    private static String categoryNameDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "categoryId";
    private static int pageDefault = 1;

    @GetMapping(value = "/categoryGetAllData")
    public ModelAndView getAllData(Optional<String> categoryNameSearch, Optional<Integer> page,
                                   Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("category");
        categoryNameDefault = categoryNameSearch.orElse(categoryNameDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        Page<Category> listCategory = categoryService.displayData(categoryNameDefault, pageDefault - 1, size,
                directionDefault, sortByDefault);
        mav.addObject("listCategory", listCategory.getContent());
        mav.addObject("totalPage", listCategory.getTotalPages());
        mav.addObject("currentPage", pageDefault);
        mav.addObject("categoryNameDefault", categoryNameDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }


    @PostMapping(value = "/create")
    public String createCategories(Category category) {
        boolean result = categoryService.saveOrUpdate(category);
        if (result) {
            return "redirect:categoryGetAllData";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ResponseEntity<String> initUpdate(int categoryId) {
        //Bước 1 :gọi sang CategoryService lấy thông tin sp theo categoryId
        Category categoryEdit = categoryService.findById(categoryId);
        CategoryReqDto categoryUpdateEdit = new CategoryReqDto(categoryEdit.getCategoryId(), categoryEdit.getCategoryName(), categoryEdit.getCategoryDescription(), categoryEdit.isCategoryStatus());
        //Chuyen du lieu tu java object sang JSON
        String json = new Gson().toJson(categoryUpdateEdit);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }


    @PostMapping("/update")
    public String updateCategory(Category categoryEdit) {
        boolean result = categoryService.saveOrUpdate(categoryEdit);
        if (result) {
            return "redirect:categoryGetAllData?page=1";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/delete")
    public ModelAndView deleteCategories(@RequestParam int catalogIdDelete) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/categoryController/categoryGetAllData?page=1");
        String success = "success";
        String error = "error";
        boolean result = categoryService.delete(catalogIdDelete);
        if (result) {
            mav.addObject("message", success);
        } else {
            mav.addObject("message", error);
        }
        return mav;
    }



}
