
JBOSS HTTPs / Secure connector

1. https://community.jboss.org/thread/194777
http://theworldofapenguin.blogspot.com.au/2007/06/create-your-own-ca-with-tinyca2-part-2.html

test
openssl s_client -cert client-cert.pem -key clientkey.pem -connect localhost:8443 -debug -CAfile housing_ca-cacert.pem

Inside standalone.xml :     subsystem xmlns="urn:jboss:domain:web:

  	<system-properties>  
		<property name="javax.net.ssl.trustStore" value="/home/mitja/housing.jks"/>
	 	<property name="javax.net.ssl.trustStorePassword" value="p"/>
    </system-properties>

	<connector name="https" protocol="HTTP/1.1" scheme="https" socket-binding="https" enable-lookups="false" secure="true">
                <ssl name="ssl" key-alias="jbossserver" password="p" certificate-key-file="/home/mitja/housing.jks" protocol="TLSv1" verify-client="true"/>
            </connector>
            
  <security-domain name="RequireCertificateDomain">
        <authentication>
            <login-module code="CertificateRoles" flag="required">
                <module-option name="securityDomain" value="RequireCertificateDomain"/>
                <module-option name="verifier" value="org.jboss.security.auth.certs.AnyCertVerifier"/>
            </login-module>
        </authentication>
        <jsse keystore-password="p" keystore-url="/home/mitja/housing.jks" truststore-password="p" truststore-url="/home/mitja/housing.jks"/>
    </security-domain>
    
    
    Custom login form
    
    http://roneiv.wordpress.com/2008/03/15/using-webauthentication-in-jboss/
    
    web.xml
    
    <login-config>
    <auth-method>FORM</auth-method>
    <form-login-config>
     <form-login-page>/login.faces</form-login-page>
     <form-error-page>/loginFailed.faces</form-error-page>
    </form-login-config>
   </login-config>
    <servlet>
    <servlet-name>LoginServlet</servlet-name>
    <servlet-class>com.test.servlet.LoginServlet</servlet-class>
  </servlet>
   <servlet-mapping>
    <servlet-name>LoginServlet</servlet-name>
    <url-pattern>/LoginServlet</url-pattern>
  </servlet-mapping>
  
login.jsp
  
  <form method="POST" name="loginform" action="${pageContext.request.contextPath}/LoginServlet">
<table style="vertical-align: middle;">
<tr>
<td>Username:</td>
<td><input type="text" name="j_username"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="j_password"/></td>
</tr>
<tr>
<td><input type="submit" value="Login" /></td>
</tr>
</table>
</form>

Servlet

public class LoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doPost(req, resp);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String user = req.getParameter("j_username");
        String pass = req.getParameter("j_password");
        WebAuthentication webAuthentication = new WebAuthentication();
        if(    webAuthentication.login(user, pass))
        {
            String redirectUrl = "";
            String referer = req.getHeader("Referer");
            resp.sendRedirect(redirectUrl);
            return;
        }
        else
        {
            System.out.println("Login attempt failed " + user);
            ...
            Handle incorrect logon, go back to login page etc
            ...
        }
    }
}

