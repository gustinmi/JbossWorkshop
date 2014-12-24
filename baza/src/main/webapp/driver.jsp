<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="database.DriverManagerDatabase" %>
<!DOCTYPE html>
<html>
<body>
<%=DriverManagerDatabase.instance.get()%>
</body>
</html>