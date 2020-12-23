package com.me.controller;

import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("changeProfile")
    public String changeProfile() {
        return "/before/change_profile.jsp";
    }


}
