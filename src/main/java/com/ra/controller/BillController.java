package com.ra.controller;

//import com.ra.model.Bill;

import com.google.gson.Gson;
import com.ra.Dto.BillDetailResDto;
import com.ra.Dto.BillReqDto;
import com.ra.model.*;
import com.ra.service.AccountService;
import com.ra.service.BillDetailService;
import com.ra.service.BillService;
import com.ra.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/billController")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private IProductService productService;
    @Autowired
    private BillDetailService billDetailService;
    private static final int size = 5;
    private static String billIdDefault = "";
    private static String directionDefault = "ASC";
    private static String sortByDefault = "billId";
    private static int pageDefault = 1;

    @GetMapping(value = "/billGetAllData")
    public ModelAndView getAllData(Optional<String> billIdSearch, Optional<Integer> page,
                                   Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("bill");
        billIdDefault = billIdSearch.orElse(billIdDefault);
        directionDefault = direction.orElse(directionDefault);
        sortByDefault = sortBy.orElse(sortByDefault);
        pageDefault = page.orElse(pageDefault);
        Page<Bill> listBill = billService.displayData(billIdDefault, pageDefault - 1, size,
                directionDefault, sortByDefault);
        List<Account> listAccount = accountService.getAllDataByAccStatusTrue();
        List<Product> listProduct = productService.getAllDataByProductStatusIsTrue();
        mav.addObject("listBill", listBill.getContent());
        mav.addObject("listAccount", listAccount);
        mav.addObject("listProduct", listProduct);
        mav.addObject("totalPage", listBill.getTotalPages());
        mav.addObject("currentPage", pageDefault);
        mav.addObject("billIdDefault", billIdDefault);
        mav.addObject("sortBy", sortByDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @PostMapping(value = "/create")
    public String createBill(Bill bill) {
        boolean result = billService.saveOrUpdate(bill);
        if (result) {
            return "redirect:billGetAllData";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/showBillDetail")
    public ResponseEntity<BillDetailResDto> showData(@RequestParam(name = "billId") Integer billId) {
        ModelAndView mav = new ModelAndView();
        BillDetailResDto billDetail = new BillDetailResDto();
        if(billId != null)
        {
            BillDetail billDetailOriginal = billDetailService.findBillDetailById(billId);
            if (billDetailOriginal != null) {
                billDetail.setBillDetailId(billDetailOriginal.getBillDetailId());
                billDetail.setPrice(billDetailOriginal.getPrice());
                billDetail.setQuantity(billDetailOriginal.getQuantity());
                billDetail.setTotal(billDetailOriginal.getTotal());
                System.out.println(billDetail);
            }
        }
        return ResponseEntity.ok(billDetail);
    }

    @PostMapping(value = "/createBillDetail")
    public String createBillDetail(BillDetail billDetail, Integer productId, Integer billId) {
        BillDetail billDetailNew = new BillDetail();
        billDetailNew.setBill(billService.findById(billId));
        billDetailNew.setProductT2(productService.findByProductId(productId));
        billDetailNew.setPrice(billDetail.getPrice());
        billDetailNew.setQuantity(billDetail.getQuantity());
        boolean result = billDetailService.save(billDetailNew);
        if (result) {
            return "redirect:billGetAllData";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    public ResponseEntity<String> initUpdate(Integer billId) {
        //Bước 1 :gọi sang CategoryService lấy thông tin sp theo categoryId
        Bill billEdit = billService.findById(billId);
        BillReqDto billInitUpdate = new BillReqDto(billEdit.getBillId(), billEdit.getCreated(), billEdit.getBillStatus(), billEdit.getAccount().getAccId());
        //Chuyen du lieu tu java object sang JSON
        String json = new Gson().toJson(billInitUpdate);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<>(json, responseHeaders, HttpStatus.OK);
    }

    @PostMapping("/updateBill")
    public String updateBill(Bill billUpdate) {
        boolean result = billService.saveOrUpdate(billUpdate);
        //Bước 2:nhận result và điều hướng sang trang hiển thị
        if (result) {
            return "redirect:billGetAllData?page=1";
        } else {
            return "error";
        }
    }

    @GetMapping(value = "/cancel")
    public ModelAndView cancel(Integer billIdCancel) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/billController/billGetAllData?page=1");
        String success = "successCancel";
        String error = "errorCancel";
        boolean result = billService.isCheckBillStatus(billIdCancel);
        if (result) {
            Bill billNew = billService.findById(billIdCancel);
            billNew.setBillStatus(5);
            boolean resultSaveOrUpdate = billService.saveOrUpdate(billNew);
            if (resultSaveOrUpdate) {
                mav.addObject("message", success);
            }
        } else {
            mav.addObject("message", error);
        }
        return mav;
    }


}
