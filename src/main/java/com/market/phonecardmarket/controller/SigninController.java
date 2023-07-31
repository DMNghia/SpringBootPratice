package com.market.phonecardmarket.controller;

import com.market.phonecardmarket.dto.UserDTO;
import com.market.phonecardmarket.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController()
public class SigninController {
    private final IUserService userService;
    @Autowired
    public SigninController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/dang-nhap"}, name = "signin")
    public ModelAndView signinGet(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        ModelAndView mav = new ModelAndView("/sign");
        mav.addObject("userDto", new UserDTO());
        return mav;
    }

    @PostMapping(value = {"/dang-nhap"})
    public ModelAndView signinPost(@ModelAttribute("userDto") UserDTO userDTO, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/sign");
        UserDTO loginUser = userService.loginUser(userDTO);
        if (loginUser != null) {
            mav = new ModelAndView();
            mav.setViewName("redirect:/");
            request.getSession().setAttribute("user", userDTO);
            return mav;
        }
        return mav;
    }
}
