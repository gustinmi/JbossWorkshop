<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.logging.*" %>
<!DOCTYPE html>
<html>
<body>

Some heavy logging started
<%

final int MAX = 10;

Logger log = Logger.getLogger("si.gustinmi");

for (int i=0; i<MAX; i++){
	
	log.fine("debug log" + i);
	log.info("info log" + i);
	log.severe("warn log" + i);
	
}

%>

and finished. 

</body>
</html>