package com.me.utils;

import lombok.Data;

import java.util.List;
@Data
public class Page<T> {

    private Integer total; // 总条数
    private Integer page;  // 当前页
    private Integer size;  // 每页展示的条数
    private List<T> rows;// 结果集



}