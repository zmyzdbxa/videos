package com.me.controller;

import com.me.dao.SpeakerMapper;
import com.me.pojo.QueryVo;
import com.me.pojo.Speaker;
import com.me.service.SpeakerService;
import com.me.utils.Page;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("speaker")
public class SpeakerController {

    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("showSpeakerList")
    public String showSpeakerList(Model model, QueryVo queryVo) {
        model.addAttribute("queryVo", queryVo);
        Page<Speaker> page = speakerService.findAll(queryVo);
        model.addAttribute("page", page);
        return "/behind/speakerList";
    }

    @RequestMapping("speakerDel")
    public String speakerDel(String id) {
        speakerService.deleteSpeakerById(id);
        return "success";
    }

    @RequestMapping("addSpeaker")
    public String addSpeaker() {
        return "behind/addSpeaker";
    }

    @RequestMapping("edit")
    public String edit(String id, Model model) {
        Speaker speaker = speakerService.selectById(id);
        model.addAttribute("speaker", speaker);
        return "behind/addSpeaker";
    }

    @RequestMapping("saveOrUpdate")
    public String addSpeaker(Speaker speaker) {
        speakerService.addSpeaker(speaker);
        return "redirect:showSpeakerList";
    }
}
