package com.portal;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class PageBean {

	protected HttpServletRequest request = null;
	protected ServletContext context = null;
	protected boolean isLoggedIn;
	private String authenticatedUserName;
	
	public PageBean() {}

	public boolean process() {

		if (request == null || context == null) { throw new ExceptionInInitializerError("Wrong init of bean params"); }
		Boolean loggedIn = (Boolean)request.getSession().getAttribute("logged_in");
		
		if (null!=loggedIn && loggedIn){ //already logged in
			authenticatedUserName = (String) request.getSession().getAttribute("user_name");
			return true;
		}else{ //auth cookie
			String preexistingCookie = getUserFromCookie();
			if (null!=preexistingCookie&&!preexistingCookie.isEmpty()){
				String[] cookieValues = preexistingCookie.split(":");
				String user = cookieValues[0];
				String cryptedPassword = cookieValues[1];
				boolean ok = Database.instance.checkUser(user, cryptedPassword);
				if (ok){
					request.getSession().setAttribute("logged_in", true);
					authenticatedUserName = user;
					return ok;
				}
			}	
		}
		
		//you need to login
		return false;
	}
	
	private String getUserFromCookie() {

		String cookieName = "_AUTH";
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					return c.getValue();
				}
			}
		}
		return "";
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}
	
	public String getUsername(){
		return this.authenticatedUserName;
	}
		
}
