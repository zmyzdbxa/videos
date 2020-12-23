package com.me.service.impl;

import com.me.dao.AdminMapper;
import com.me.pojo.Admin;
import com.me.pojo.AdminExample;
import com.me.service.AdminService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {

       /* AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);*/


        Admin admin = adminMapper.findByUsername(username);
        if (admin.getUsername() == null) {
            throw new RuntimeException("账号不能为空");
        }

        if (!admin.getPassword().equals(password)) {
            throw new RuntimeException("密码错误");
        }

        return admin;
    }
}
