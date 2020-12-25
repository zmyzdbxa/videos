package com.me.dao;

import java.util.List;

import com.me.pojo.QueryVo;
import com.me.pojo.Video;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface VideoMapper {

    List<Video> findAll(QueryVo queryVo);

    Integer count();

    void deleteVideo(int parseInt);

    void addVideo(Video video);

    Video selectById(int id);

    void updateVideo(Video video);
}
