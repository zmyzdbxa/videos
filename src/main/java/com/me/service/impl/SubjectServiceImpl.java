package com.me.service.impl;

import com.me.dao.SubjectMapper;
import com.me.pojo.Subject;
import com.me.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;


    @Override
    public List<Subject> selectAll() {
        return subjectMapper.selectAll();
    }

    @Override
    public Subject selectSubjectById(String subjectId) {
        return subjectMapper.selectSubjectById(Integer.parseInt(subjectId));
    }
}
