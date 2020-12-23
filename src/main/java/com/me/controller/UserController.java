package com.me.controller;

import com.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

//    @Autowired
//    private UserService userService;

    @RequestMapping("index")
    public String changeProfile() {
        return "before/index";
    }

    @RequestMapping("changeAvatar")
    public String changeAvatar() {
        return "before/change_avatar";
    }


}
