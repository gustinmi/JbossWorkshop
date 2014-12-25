<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="database.PoolDatabase" %>
<!DOCTYPE html>
<html>
<body>
<%=PoolDatabase.instance.get()%>
</body>
</html>