package com.me.controller;

import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("showMyProfile")
    public String showMyProfile() {
        return "before/my_profile";
    }

}
