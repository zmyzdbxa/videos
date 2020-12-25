package com.me.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Speaker {
    private Integer id;
    private String speakerName;
    private String speakerDesc;
    private String speakerJob;
    private String headImgUrl;

}
