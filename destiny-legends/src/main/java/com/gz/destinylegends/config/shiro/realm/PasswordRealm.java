package com.gz.destinylegends.config.shiro.realm;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.manager.UserManager;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/30 22:25
 * @Description
 */
public class PasswordRealm extends AuthorizingRealm {

    @Autowired
    private UserManager userManager;

    @Override
    protected boolean isPermitted(Permission permission, AuthorizationInfo info) {
        boolean flag = false;
        SimpleAuthenticationInfo simpleAuthenticationInfo = (SimpleAuthenticationInfo) info;
        PrincipalCollection principals = simpleAuthenticationInfo.getPrincipals();
        for (Object principal : principals) {
            // 临时开放权限
            if ("admin".equals(principal)) {
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
        System.out.println(JSONObject.toJSONString(principalCollection));
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        return (AuthorizationInfo) info;
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
