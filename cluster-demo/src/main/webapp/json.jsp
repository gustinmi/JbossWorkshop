<%@page language="java" contentType="application/json; charset=UTF-8"%>
<%
    String jsonStr = "{\"param1\":\"val1\"}";
    response.setContentType("application/json;charset=UTF-8");
    out.print(jsonStr);
    out.flush();
%>
