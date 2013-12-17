<%@page
 contentType="text/html"
 import="java.util.*,javax.naming.*,javax.sql.DataSource,java.sql.*"
 %>
 <%
  //With datasource 
  DataSource ds = null;
  Connection con = null; 
  PreparedStatement pr = null; 
  InitialContext ic; 
  try {
  	ic = new InitialContext();
  	ds = (DataSource)ic.lookup("java:jboss/datasources/mysqlDS");
  	con = ds.getConnection(); 
  	pr = con.prepareStatement("SELECT COMMENT FROM ENGINES");
  	ResultSet rs = pr.executeQuery();
  	while (rs.next()) {
  		out.println("<br> " +rs.getString("COMMENT")); 
  	}
  	rs.close();
  	pr.close();
  }catch(Exception e){
  	out.println("Exception thrown " +e); 
  }finally{
  	if(con != null){
  		con.close();
 	}      
}
%>