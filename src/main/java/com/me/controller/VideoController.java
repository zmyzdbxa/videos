package com.me.controller;


import com.me.dao.SpeakerMapper;
import com.me.pojo.Course;
import com.me.pojo.QueryVo;
import com.me.pojo.Speaker;
import com.me.pojo.Video;
import com.me.service.CourseService;
import com.me.service.SpeakerService;
import com.me.service.VideoService;
import com.me.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private SpeakerService speakerService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("list")
    public String list(Model model, QueryVo queryVo) {
        model.addAttribute("queryVo", queryVo);
        Page<Video> page = videoService.findAll(queryVo);
        model.addAttribute("page", page);

        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);

        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        return "behind/videoList";
    }

    @RequestMapping("videoDel")
    public String videoDel(String id) {
        videoService.deleteVideoById(id);
        return "success";
    }

    @RequestMapping("delBatchVideos")
    public String delBatchVideos(String ids) {
        videoService.deleteVideo(ids);
        return "redirect:list";
    }

    @RequestMapping("addVideo")
    public String addVideo(Model model) {
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "behind/addVideo";
    }

    @RequestMapping("edit")
    public String edit(String id, Model model) {
        Video video = videoService.selectById(id);
        model.addAttribute("video", video);
        List<Course> courseList = courseService.findAll();
        model.addAttribute("courseList", courseList);
        List<Speaker> speakerList = speakerService.selectAll();
        model.addAttribute("speakerList", speakerList);
        return "behind/addVideo";
    }

    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(Video video) {
        videoService.addVideo(video);
        return "redirect:list";
    }
}
