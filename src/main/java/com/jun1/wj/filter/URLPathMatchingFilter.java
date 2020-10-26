package com.jun1.wj.filter;

import lombok.extern.log4j.Log4j2;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class URLPathMatchingFilter extends PathMatchingFilter {
//    @Autowired
//    AdminPermissionService
//    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 放行 options 请求，否则无法让前端带上自定义的header信息，导致 sessionID 改变， shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        // 使用 shiro 验证
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            System.out.println(subject.isRemembered());
            System.out.println(subject.isAuthenticated());
            return false;
        }
        return true;
    }
}
