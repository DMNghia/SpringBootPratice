package com.market.phonecardmarket.controller;

import com.market.phonecardmarket.dto.UserDTO;
import com.market.phonecardmarket.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SignupController {

    private final IUserService userService;

    public SignupController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dang-ky")
    public ModelAndView signupGet() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/dang-nhap");
        return mav;
    }

    @PostMapping("/dang-ky")
    public ModelAndView signupPost(@ModelAttribute("userDto")UserDTO userDTO) {
        ModelAndView mav = new ModelAndView();
        if (userService.checkEmailExists(userDTO.getEmail())) {
            mav = new ModelAndView("/sign");
            mav.addObject("emailMessageErr", "Email đã tồn tại");
        } else {
        }
        return mav;
    }
}
