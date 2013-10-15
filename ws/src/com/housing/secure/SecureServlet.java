package com.housing.secure;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
//import org.bouncycastle.asn1.x509.X509Name;
//import org.bouncycastle.jce.PrincipalUtil;
//import org.bouncycastle.jce.X509Principal;

@WebServlet("/SecureServlet")
public class SecureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		boolean valid = true;
//        try {
//            X509Certificate[] certs = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
//            X509Certificate cert = certs[0];
//            if (null == cert) {
//                System.out.print("Could not extract certificate from request");
//                valid = false;
//            }
            
//            cert.checkValidity(new Date()); // will throw exception if not valid
//            final X509Principal principal = PrincipalUtil.getSubjectX509Principal(cert);
//            final X500Principal issuerX500Principal = ((X509Certificate) cert).getIssuerX500Principal();
//            if (null == principal || null == issuerX500Principal) {
//                log.error("Could not extract principal or issuer from certificate");
//                return null;
//            }
//            // username
//            final Vector<?> vcn = principal.getValues(X509Name.CN);
//            username = (String) NIL.getArrayElement(vcn, 0);
//            log.info("Certificate username : " + username);
//
//            // serial number
//            final BigInteger vser = cert.getSerialNumber();
//            serial = vser.toString();
//            log.info("Certificate serial : " + serial);
//
//            // certificate issuers CN
//            final String strRawIssuer = issuerX500Principal.toString();
//            final String strBakedIssuer = strRawIssuer.trim().replaceAll("\\s", "").trim();
//            log.info("Cert issuer is:" + strBakedIssuer);

//       } catch (Throwable e) {
//        	e.printStackTrace();
//        }
		
		response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{ \"status\":\"ok\", \"msg\": \"Hello from secure servlet\"}");
        out.flush();
        return;
	}

}
