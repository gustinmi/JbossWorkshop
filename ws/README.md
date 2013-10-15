
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