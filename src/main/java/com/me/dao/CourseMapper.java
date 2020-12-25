package com.me.dao;

import java.util.List;

import com.me.pojo.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {

    List<Course> findAll();
}