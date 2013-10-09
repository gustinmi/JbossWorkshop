package com.portal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portal.Database;
import com.portal.Utils;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginApi" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uid = request.getParameter("ime");
		String pwd = request.getParameter("geslo");
		if (uid == null || uid.isEmpty() || pwd == null || pwd.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		Date d = new Date();
		Boolean ok = Database.instance.checkUser(uid,pwd);
		if (!ok) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
			return;
		}
		String hashed = uid + ":" + Utils.getMd5sum(pwd);
		Cookie cookie = new Cookie("_AUTH", hashed);
		cookie.setMaxAge(365 * 24 * 60 * 60); //one year
		response.addCookie(cookie);
		request.getSession().setAttribute("logged_in", true);
		request.getSession().setAttribute("user_name", uid);
		response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{\"status\":\"ok\"}");
        out.flush();
        return;
	}

}
