package com.tianmaying.controller;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();

        if(session.getAttribute("CURRENT_USER")!=null){

            return true;
        }

        response.sendRedirect("/login?next=".concat(request.getRequestURI()));
        return false;
    }


}
