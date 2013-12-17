package com.housing.secure;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.security.annotation.SecurityDomain;

@WebServlet("/JaasServlet")
//REPLACES web.xml configuration, but its's slower on load / redeploy due to annotationprocessor
@ServletSecurity(@HttpConstraint(rolesAllowed = { "all" }))  
@DeclareRoles("all") 
public class JaasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String user = request.getParameter("j_username");
	    //String pass = request.getParameter("j_password");
		Principal principal = request.getUserPrincipal();  
		response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{ \"status\":\"ok\", \"msg\": \"" + principal.getName() +"\"}");
        out.flush();
        return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{ \"status\":\"ok\", \"msg\": \"Hello from secure servlet\"}");
        out.flush();
        return;
	}

}
