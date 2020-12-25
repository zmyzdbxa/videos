package com.me.service.impl;

import com.me.dao.SpeakerMapper;
import com.me.pojo.QueryVo;
import com.me.pojo.Speaker;
import com.me.service.SpeakerService;
import com.me.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeakerServiceImpl implements SpeakerService {

    @Autowired
    private SpeakerMapper speakerMapper;


    @Override
    public Page<Speaker> findAll(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage() -1) * queryVo.getSize());
        List<Speaker> speakerList = speakerMapper.findAll(queryVo);
        Integer count = speakerMapper.count();
        Page<Speaker> page = new Page<>();
        page.setPage(queryVo.getPage());
        page.setSize(queryVo.getSize());
        page.setRows(speakerList);
        page.setTotal(count);
        return page;

    }

    @Override
    public List<Speaker> selectAll() {
        return speakerMapper.selectAll();
    }

    @Override
    public void deleteSpeakerById(String id) {
        speakerMapper.deleteSpeakerById(Integer.parseInt(id));
    }

    @Override
    public void addSpeaker(Speaker speaker) {
        if (speaker.getId() == null) {
            speakerMapper.addSpeaker(speaker);
        } else {
            speakerMapper.updateSpeaker(speaker);
        }

    }

    @Override
    public Speaker selectById(String id) {
        return speakerMapper.selectById(Integer.parseInt(id));
    }
}
