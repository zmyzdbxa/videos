package com.me.service;

import com.me.pojo.Course;
import com.me.pojo.Subject;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Subject findById(Integer id);
}
