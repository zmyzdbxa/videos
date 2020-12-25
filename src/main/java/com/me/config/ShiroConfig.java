package com.me.config;

import com.me.shiro.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    public MyRealm createMyRealm() {
        return new MyRealm();
    }

    @Bean
    public SecurityManager createSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(createMyRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        shiroFilterFactoryBean.setLoginUrl("/admin/toLogin");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("/css/**", "anon");
        map.put("/js/**", "anon");
        map.put("/font/**", "anon");
        map.put("/img/**", "anon");
        map.put("/images/**", "anon");

        map.put("/admin/toLogin", "anon");
        map.put("behind/login", "anon");
        map.put("behind/index", "authc");
        map.put("/admin/exit", "logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;


    }
}
