package com.me.dao;

import java.util.List;

import com.me.pojo.Subject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMapper {

    List<Subject> selectAll();

    Subject selectSubjectById(int parseInt);
}