package com.me.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryVo {
    private Integer courseId;
    private Integer speakerId;
    private String title;

    private Integer start;
    private Integer size = 10;
    private Integer page = 1;
}
