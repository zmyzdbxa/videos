package com.me.dao;

import java.util.List;

import com.me.pojo.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    Admin findByUsername(String username);
}