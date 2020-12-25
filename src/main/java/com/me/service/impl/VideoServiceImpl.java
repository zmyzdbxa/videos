package com.me.service.impl;



import com.me.dao.VideoMapper;
import com.me.pojo.QueryVo;
import com.me.pojo.Video;
import com.me.service.VideoService;
import com.me.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;


    @Override
    public Page<Video> findAll(QueryVo queryVo) {
        queryVo.setStart((queryVo.getPage()-1) * queryVo.getSize());
        List<Video> videoList = videoMapper.findAll(queryVo);
        Integer count = videoMapper.count();
        Page<Video> page = new Page<>();
        page.setRows(videoList);
        page.setPage(queryVo.getPage());
        page.setSize(queryVo.getSize());
        page.setTotal(count);
        return page;
    }

    @Override
    public void deleteVideo(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            if (split != null && !split.equals("")) {
                videoMapper.deleteVideo(Integer.parseInt(split[i]));
            }
        }

    }

    @Override
    public void addVideo(Video video) {
        if (video.getId() == null) {
            videoMapper.addVideo(video);
        } else {
            videoMapper.updateVideo(video);
        }

    }

    @Override
    public void deleteVideoById(String id) {
        videoMapper.deleteVideo(Integer.parseInt(id));
    }

    @Override
    public Video selectById(String id) {
        return videoMapper.selectById(Integer.parseInt(id));
    }


}
