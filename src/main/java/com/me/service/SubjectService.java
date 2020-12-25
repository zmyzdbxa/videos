package com.me.service;

import com.me.pojo.Subject;

import java.util.List;

public interface SubjectService {


    List<Subject> selectAll();

    Subject selectSubjectById(String subjectId);
}
