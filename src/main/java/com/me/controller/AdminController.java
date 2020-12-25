package com.me.controller;

import com.me.pojo.Admin;
import com.me.service.AdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Api
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) {
        Admin login = adminService.login(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("userName", login.getUsername());
        return "success";
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "behind/login";
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:behind/login";
    }
}
