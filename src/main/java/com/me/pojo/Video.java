package com.me.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private Integer id;
    private String title;
    private String detail;
    private Integer time;
    private Integer speakerId;
    private Integer CourseId;
    private String videoUrl;
    private String imageUrl;
    private Integer playNum;

    private Speaker speaker;
}
