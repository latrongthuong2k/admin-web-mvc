package com.ra.controller;

import com.ra.model.StatisticalPerformance;
import com.ra.service.AccountService;
import com.ra.service.BillService;
import com.ra.service.IProductService;
import com.ra.service.IStatiscalMoneyAndDateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    private final AccountService accountService;
    private final IProductService productService;
    private final BillService billService;
    private final IStatiscalMoneyAndDateService statisticService;

    public DashboardController(AccountService accountService, IProductService productService, BillService billService, IStatiscalMoneyAndDateService statisticService) {
        this.accountService = accountService;
        this.productService = productService;
        this.billService = billService;
        this.statisticService = statisticService;
    }


    @GetMapping(value = "/dashBoard-data")
    public ModelAndView getAllData() {

        ModelAndView mav = new ModelAndView("dashboard");
        int accActive = accountService.statisticalAccountActive();
        int accInActive = accountService.statisticalAccountInActive();
        System.out.println(accActive +"///"+ accInActive );

        int productActive = productService.statisticalProductActive();
        int productInActive = productService.statisticalProductInActive();

        int pendingBills = billService.statisticalPending();
        int approveBills = billService.statisticalApproved();
        int deliveringBills = billService.statisticalDelivering();
        int receivedBills = billService.statisticalReceived();
        int canceledBills = billService.statisticalCanceled();
        List<StatisticalPerformance> listStatisticalMoneyAndDate=statisticService.total();

        // object
        mav.addObject("accActive", accActive);
        mav.addObject("accInActive", accInActive);

        mav.addObject("productActive", productActive);
        mav.addObject("productInActive", productInActive);

        mav.addObject("pendingBills", pendingBills);
        mav.addObject("approveBills", approveBills);
        mav.addObject("deliveringBills", deliveringBills);
        mav.addObject("receivedBills", receivedBills);
        mav.addObject("canceledBills", canceledBills);
        mav.addObject("listStatisticalMoneyAndDate", listStatisticalMoneyAndDate);
        return mav;
    }
}
