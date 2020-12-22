package com.me.service;

import com.me.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin login(String username, String password);
}
