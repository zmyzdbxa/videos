package com.me.shiro;

import com.me.dao.AdminMapper;
import com.me.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal();


        HashSet<String> permissions = new HashSet<>();
        permissions.add("user:add");
        permissions.add("user.update");
        permissions.add("user.delete");
        permissions.add("user.findAll");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(permissions);

        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Object credentials = token.getCredentials();
        String password = new String((char[]) credentials);
        if ("jack".equals(username) && "123".equals(password)) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());

            return simpleAuthenticationInfo;
        }
        throw new RuntimeException("认证失败");
    }
}
