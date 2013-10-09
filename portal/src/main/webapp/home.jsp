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

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Portal</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/home.css" />
</head>
<body>
 	<div class="menu header">
        <a href="#" id="logout">logout</a>
    </div>
    <h5>Logged in <%=pageBean.getUsername()%></h5>
    <div class="users">
    <table class="grid">
        <caption>Some users</caption>
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
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script>
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