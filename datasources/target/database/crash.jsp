<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="database.DriverManagerCrashDb" %>
<!DOCTYPE html>
<html>
<body>
<%=DriverManagerCrashDb.instance.get()%>
</body>
</html>