package com.atguigu.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * projectName: b2c-cloud-store
 *
 * @author: 赵伟风
 * time: 2022/10/22 16:02 周六
 * description: 登录保护拦截器
 */
public class LoginProtectInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.err.println("LoginProtectInterceptor.preHandle");


        if (null == request.getSession().getAttribute("userInfo")) {
            //对应拦截路径,没有登录,跳转到登录页面!
            //request.getSession().setAttribute(Constants.USER_ERROR_MSG, "请重新登陆");
            //重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/index.html");
            return false;
        } else {
            //放行
            return true;
        }
    }
}
