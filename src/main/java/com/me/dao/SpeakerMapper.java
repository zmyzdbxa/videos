package com.me.dao;

import java.util.List;

import com.me.pojo.QueryVo;
import com.me.pojo.Speaker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerMapper {

    List<Speaker> findAll(QueryVo queryVo);

    Integer count();

    List<Speaker> selectAll();

    void deleteSpeakerById(int parseInt);

    void addSpeaker(Speaker speaker);

    Speaker selectById(int parseInt);

    void updateSpeaker(Speaker speaker);
}