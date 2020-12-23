package com.me.controller;

import com.me.pojo.Course;
import com.me.pojo.Subject;
import com.me.service.CourseService;
import com.me.service.SubjectService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping("findAll")
    public Map<String, Object> findAll() {
        List<Course> courses = courseService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);
        return map;
    }

    @RequestMapping("course/{subjectId}")
    public String course(@PathVariable Integer subjectId, Model model) {
        Subject subject = subjectService.selectSubjectById(subjectId);
        model.addAttribute("subject", subject);
        return "/before/course";
    }
}
