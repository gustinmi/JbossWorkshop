package com.portal.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LogoutServlet", urlPatterns = { "/Logout" })
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	request.getSession().invalidate();
    	Cookie cookie = new Cookie ("_AUTH", "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect(request.getContextPath() + "/login.html");  
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
    }

}
