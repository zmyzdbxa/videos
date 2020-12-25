package com.me.service;

import com.me.pojo.QueryVo;
import com.me.pojo.Speaker;
import com.me.utils.Page;

import java.util.List;

public interface SpeakerService {

    Page<Speaker> findAll(QueryVo queryVo);

    List<Speaker> selectAll();

    void deleteSpeakerById(String id);

    void addSpeaker(Speaker speaker);

    Speaker selectById(String id);
}
