package com.ra.controller;

import com.google.gson.Gson;
import com.ra.Dto.ProductResDto;
import com.ra.model.*;
import com.ra.service.*;
import com.ra.service.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productController")
public class ProductController {
    private final IProductService productService;
    private final CategoryService categoryService;
    private final IUploadFileService uploadFileService;
    private final IProductImageService imageService;
    private static final int size = 5;
    private static String defaultValue = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "productId";
    private static int pageDefault = 1;

    public ProductController(IProductService productService, CategoryService categoryService, IUploadFileService uploadFileService, IProductImageService imageService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.uploadFileService = uploadFileService;
        this.imageService = imageService;
    }

    @GetMapping(value = "/productGetAllData")
    public ModelAndView getAllData(Optional<String> searchTerm, Optional<Integer> page,
                                   Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("product");
        defaultValue = searchTerm.orElse(defaultValue);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        Page<Product> listProduct = productService.displayData(defaultValue, pageDefault - 1, size,
                directionDefault, sortByDefault);
        List<Category> listCategory = categoryService.findAllDataByCategoryStatusIsTrue();
        mav.addObject("listProduct", listProduct.getContent());
        mav.addObject("listCategory", listCategory);
        mav.addObject("totalPage", listProduct.getTotalPages());
        mav.addObject("currentPage", pageDefault);
        mav.addObject("productNameAndTittleDefault", defaultValue);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @PostMapping(value = "/create")
    public String createProduct(Product product,@RequestParam(name = "productImageReq", required = false) MultipartFile productImage) {
        if (productImage != null && !productImage.isEmpty()) {
            String urlImage = uploadFileService.uploadFile(productImage);
            product.setProductImageName(productImage.getOriginalFilename());
            product.setImage(urlImage);
        }
        productService.save(product);
        return "redirect:productGetAllData";
    }

    @GetMapping("/initUpdate")
    public ResponseEntity<ProductResDto> initUpdate(@RequestParam(name = "productId") Integer productId) {
        Product productEdit = productService.findByProductId(productId);
        ProductResDto productUpdate = new ProductResDto();
        productUpdate.setProductId(productEdit.getProductId());
        productUpdate.setProductName(productEdit.getProductName());
        productUpdate.setPrice(productEdit.getPrice());
        productUpdate.setTittle(productEdit.getTittle());
        productUpdate.setProductDescription(productEdit.getProductDescription());
        productUpdate.setImage(productEdit.getImage());
        productUpdate.setProductUnit(productEdit.getProductUnit());
        productUpdate.setProductStatus(productEdit.isProductStatus());
        productUpdate.setCategoryId(productEdit.getCategory().getCategoryId());
        productUpdate.setCategoryName(productEdit.getCategory().getCategoryName());
        return ResponseEntity.ok(productUpdate);
    }

    @PostMapping("/update")
    public String updateProduct(Product productEdit, @RequestParam(name = "productImageReq", required = false) MultipartFile productImage) {
        Product productOriginal = productService.findByProductId(productEdit.getProductId());
        if (productImage != null && !productImage.isEmpty()) {
            String urlImage = uploadFileService.uploadFile(productImage);
            productEdit.setProductImageName(productImage.getOriginalFilename());
            productEdit.setImage(urlImage);
        }

        boolean result = productService.update(productEdit, productOriginal);
        if (result) {
            return "redirect:productGetAllData";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/delete")
    public ModelAndView deleteProduct(@RequestParam Integer productIdDelete) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/productController/productGetAllData?page=1");
        String success = "success";
        String error = "error";
        Product product = productService.findByProductId(productIdDelete);
        if (product != null) {
            if (product.getListBillDetail().isEmpty()) {
                boolean result = productService.delete(product);
                if (result) {
                    mav.addObject("message", success);
                }
            } else {
                mav.addObject("message", error);
            }
        }
        return mav;
    }

    @GetMapping(value = "/showData")
    public ModelAndView showData(Integer productId) {
        ModelAndView mav = new ModelAndView();
        Product productShow = productService.findByProductId(productId);
        List<ImageProduct> listImageProduct = imageService.findAllDataByProduct_ProductId(productId);
        if (productShow != null) {
            mav.setViewName("productDetail");
            mav.addObject("productShow", productShow);
            mav.addObject("listImageProduct", listImageProduct);
        } else {
            mav.setViewName("error");
        }
        return mav;
    }


}
