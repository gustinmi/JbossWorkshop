<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="database.DriverManagerLeak" %>
<!DOCTYPE html>
<html>
<body>
<%=DriverManagerLeak.instance.get()%>
</body>
</html>