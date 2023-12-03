package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    @GetMapping(value = "/login")
    public ModelAndView loginForm() {
        return new ModelAndView("login");
    }

    @PostMapping(value = "/login")
    public ModelAndView createCategories(String email, String password) {
        ModelAndView mav = new ModelAndView();
        if (email.equals("latrongthuong@gmail.com") && password.equals("1234")) {
            mav.setViewName("redirect:/dashboard/dashBoard-data");
        } else {
            mav.setViewName("login");
            String messageError = "*Email hoặc Password không đúng,vui lòng nhập lại";
            mav.addObject("messageError", messageError);
        }

        return mav;
    }

}
