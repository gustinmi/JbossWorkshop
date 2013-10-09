<!DOCTYPE html>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="pageBean" scope="request" class="com.portal.PageBean">
    <jsp:setProperty name="pageBean" property="request" value="<%= request %>" />
    <jsp:setProperty name="pageBean" property="context" value="<%= application %>" />
</jsp:useBean>
<%
boolean ok = pageBean.process();
if (ok) { //render page only if user is logged in
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Portal</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/home.css" />
</head>
<body>
 	<div class="menu header">
 		<span>Logged in <b><%=pageBean.getUsername()%></b></span>
        <a href="#" id="logout">Logout?</a>
    </div>
    
    <div class="users">
    <table class="grid">
        <caption>Table of users from database</caption>
        <thead>
        <tr>
            <th>User ID</th>
            <th>User name</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    </div>
    
    <div class="edit">
		<div>    
			<label for="geslo">Novo ime</label>
			<input id="name" type="text" />
		</div>
		<div>
			<input type="button" id="update" value="Popravi" />
		</div>
    </div>
    
    
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script>
		//this is a way to get Java variables to Javascript on client (if you need it) 
	    var USER = '<%=pageBean.getUsername()%>', CONTEXT_PATH = '<%=request.getContextPath()%>';
	</script>
	<script src="<%=request.getContextPath()%>/home.js"></script>
</body>
<%
} else {
	response.sendRedirect(request.getContextPath() + "/login.html");
	return;
}
%>
</html>