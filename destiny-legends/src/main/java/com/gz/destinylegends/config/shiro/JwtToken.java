package com.gz.destinylegends.config.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/30 23:55
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken implements HostAuthenticationToken {

    private String token;
    private String host;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String getHost() {
        return host;
    }
}
