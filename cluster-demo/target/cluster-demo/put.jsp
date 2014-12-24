 <%@page import="java.util.logging.*" %>
 <html>
 <body>
 <h2>Set Current Time</h2>
 <%
     System.out.println( "Putting date now" );
     session.setAttribute("current.time", new java.util.Date());
     Logger logger = Logger.getLogger("moja.aplikacija");
     logger.info("_____________ hello __________");
 %>
 The time is set to <%= session.getAttribute("current.time") %>
 </body>
 </html>




