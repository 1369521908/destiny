package com.gz.destinylegends.config.shiro.realm;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/30 22:25
 * @Description
 */
@Slf4j
public class PasswordRealm extends AuthorizingRealm {

    @Autowired
    private UserManager userManager;

    @Override
    protected boolean isPermitted(Permission permission, AuthorizationInfo info) {
        boolean flag = false;
        SimpleAuthorizationInfo simpleAuthenticationInfo = (SimpleAuthorizationInfo) info;
        Set<String> stringPermissions = simpleAuthenticationInfo.getStringPermissions();
        for (Object p : stringPermissions) {
            // 临时开放权限
            if ("super:admin".equals(p)) {
            // if (permission.equals(p)) {
                flag = true;
            }
        }
        return flag || super.isPermitted(permission, info);
    }

    /**
     * TODO 鉴权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("开始进行鉴权,{}",JSONObject.toJSONString(principalCollection));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // TODO 临时权限
        Collection permissions = new ArrayList();
        permissions.add("super:admin");
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * TODO 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println(JSONObject.toJSONString(authenticationToken));
        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        if (userManager.login(userName, password)) {
            return new SimpleAuthenticationInfo(userName, password, getName());
        } else {
            throw new AuthenticationException();
        }
    }
}
