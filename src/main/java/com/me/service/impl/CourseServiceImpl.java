package com.me.service.impl;

import com.me.dao.CourseMapper;
import com.me.pojo.Course;
import com.me.pojo.Subject;
import com.me.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.selectByExample(null);
    }

    @Override
    public Subject findById(Integer id) {
        return null;
    }
}
