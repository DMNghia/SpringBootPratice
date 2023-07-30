package com.market.phonecardmarket.controller;

import com.market.phonecardmarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/signin")
public class SigninController {
    private final IUserService userService;
    @Autowired
    public SigninController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView signinGet() {
        ModelAndView mav = new ModelAndView("/home");

        return mav;
    }
}
