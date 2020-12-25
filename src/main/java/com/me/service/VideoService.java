package com.me.service;


import com.me.pojo.QueryVo;
import com.me.pojo.Video;
import com.me.utils.Page;
import org.springframework.ui.Model;

public interface VideoService {

    Page<Video> findAll(QueryVo queryVo);

    void deleteVideo(String ids);

    void addVideo(Video video);

    void deleteVideoById(String id);

    Video selectById(String id);
}
