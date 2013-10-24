package com.housing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//@WebService()
public class HelloWorld {
//
//	@Inject private Config cfg; 
//	
//	/**
//	 * Wsdl location: http://localhost:8080/ws/HelloWorldService?wsdl
//	 * @param name
//	 * @return
//	 */
//	
	//@WebMethod()
	public String sayHello(String name) {
	    System.out.println("Hello: " + name);
	    return "Hello " + name + "!";
	}
//	
//	
//	//@PostConstruct
//	//@WebMethod(exclude=true)
//	public void initService() {
//		if (cfg.isDebug())
//			System.out.print("Debug");
//	}
//	
//	/**
//	 * Uploading file (much much easier than uploadint o servlet via multipart request 
//	 * @param id
//	 * @param metadata
//	 * @return
//	 */
//	@WebMethod
//	public WebResult sayHelloParams(@WebParam(name="id") String id, @WebParam(name="metadata") byte[] metadata) {
//		
//		FileOutputStream stream = null;
//		try {
//			stream = new FileOutputStream("/home/mitja/test.txt");
//		    stream.write(metadata);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//		    try {
//				stream.close();
//			} catch (IOException e) {
//			}
//		}
//		
//		return new WebResult(400, "You entered: " + id );
//	}
	
	public static class WebResult implements Serializable {
		private static final long serialVersionUID = 2279893440714881296L;
		private final int httpcode;
		private final String msg;
		public WebResult(int httpcode, String msg) {
			super();
			this.httpcode = httpcode;
			this.msg = msg;
		}
		public int getHttpcode() {
			return httpcode;
		}
		public String getMsg() {
			return msg;
		}
	}
	
}
