package com.me.service.impl;

import com.me.dao.SubjectMapper;
import com.me.pojo.Subject;
import com.me.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public Subject selectSubjectById(Integer subjectId) {
        return subjectMapper.selectByPrimaryKey(subjectId);
    }
}
