package com.me.controller;

import com.me.pojo.Subject;
import com.me.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("selectAll")
    public String selectAll(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        List<Subject> subjectList = subjectService.selectAll();
        servletContext.setAttribute("subjectList", subjectList);
        return "before/index";
    }
}
