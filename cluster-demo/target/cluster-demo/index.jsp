<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="stil.css" type="text/css" />
</head>
<body>

<h2>Hello World!</h2>
<%
    System.out.println( "Evaluating date now 1" );
    java.util.Date date = new java.util.Date();
%>
Hello!  The time is now <%= date %>
<img src="<%=application.getInitParameter("static_url")%>test.png">
</body>
</html>
