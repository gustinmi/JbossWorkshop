package org.jboss.samples.webservices;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

// http://localhost:8080/webservice/HelloWorldws?wsdl

@WebService()
public class HelloWorld {

	@WebMethod()
	public String sayHello(String name) {
	    System.out.println("Hello: " + name);
	    return "Hello " + name + "!";
	}
	
	@WebMethod
	public String sayHelloParams(@WebParam(name="id") String id, @WebParam(name="contents") byte[] metadata) {
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream("/home/jboss/test.txt");
		    stream.write(metadata);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    try {
				stream.close();
			} catch (IOException e) {
			}
		}
		
		return "saved";
	}
}
