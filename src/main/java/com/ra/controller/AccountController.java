package com.ra.controller;

import com.google.gson.Gson;
import com.ra.Dto.AccountReqDto;
import com.ra.model.Account;
import com.ra.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountController")
public class AccountController {

    private final AccountService accountService;
    private static final int size = 5;
    private static String emailDefault = "";
    private static String directionDefault = "ASC";
    private static String sortDefault = "accId";
    private static int pageDefault = 1;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accountGetAllData")
    public ModelAndView getAllData(Optional<String> emailSearch, Optional<Integer> page,
                                   Optional<String> direction, Optional<String> sortBy) {
        ModelAndView mav = new ModelAndView("account");
        emailDefault = emailSearch.orElse(emailDefault);
        directionDefault = direction.orElse(directionDefault);
        sortDefault = sortBy.orElse(sortDefault);
        pageDefault = page.orElse(pageDefault);
        Page<Account> listAccount = accountService.displayData(emailDefault, pageDefault - 1, size,
                directionDefault, sortDefault);
        mav.addObject("listAccount", listAccount.getContent());
        mav.addObject("totalPage", listAccount.getTotalPages());
        mav.addObject("currentPage", pageDefault);
        mav.addObject("emailDefault", emailDefault);
        mav.addObject("sortBy", sortDefault);
        mav.addObject("direction", directionDefault);
        return mav;
    }

    @PostMapping(value = "/create")
    public String createAccount(Account account) {
        //Thực hiện gọi sang service thực hiện thêm mới
        boolean result = accountService.saveOrUpdate(account);
        if (result) {
            return "redirect:accountGetAllData";
        } else {
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public ResponseEntity<AccountReqDto> initUpdate(int accId) {
        Account accountEdit = accountService.findById(accId);
        AccountReqDto accountUpdate = new AccountReqDto(accountEdit.getAccId(), accountEdit.getEmail(),
                accountEdit.getPassword(), accountEdit.getCreated(),
                accountEdit.isRole(), accountEdit.isAccStatus());
        return new ResponseEntity<>(accountUpdate, HttpStatus.OK);
    }

    @PostMapping("/update")
    public String updateAccount(Account accountEdit) {
        boolean result = accountService.saveOrUpdate(accountEdit);
        if (result) {
            return "redirect:accountGetAllData?page=1";
        } else {
            return "error";
        }
    }

    @PostMapping(value = "/lockAndUnlock")
    public String lockAccount(Account account) {
        boolean result = accountService.saveOrUpdate(account);
        if (result) {
            return "redirect:accountGetAllData?page=1";
        } else {
            return "error";
        }
    }


}
