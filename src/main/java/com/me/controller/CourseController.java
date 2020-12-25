package com.me.controller;

import com.me.pojo.Subject;
import com.me.service.CourseService;
import com.me.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("showCourseList")
    private String showCourseList() {
        return "redirect:../subject/selectAll";
    }

    @RequestMapping("/course/{subjectId}")
    public String course(@PathVariable String subjectId, Model model) {
        Subject subject = subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject", subject);
        return "/before/course";
    }
}
