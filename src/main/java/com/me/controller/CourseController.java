package com.me.controller;

import com.me.pojo.Course;
import com.me.service.CourseService;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("findAll")
    public Map<String, Object> findAll() {
        List<Course> courses = courseService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("courses", courses);
        return map;
    }
}
