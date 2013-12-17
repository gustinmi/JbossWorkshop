package housing.webservice.test;

import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

import webservice.HelloWorld;
import webservice.HelloWorldService;

public class WsTest {

	@Test
	public void test() throws IOException {

		RandomAccessFile fileStream = new RandomAccessFile("/home/mitja/upload.txt", "r");
		byte[] buffer = new byte[(int)fileStream.length()];
		fileStream.read(buffer);
		fileStream.close();
		
		System.out.println("Create Web Service Client...");
		HelloWorldService service1 = new HelloWorldService();
		
		System.out.println("Create Web Service...");
		HelloWorld port1 = service1.getHelloWorldPort();
		
		System.out.println("Call Web Service Operation...");
		
		System.out.println("Server said: " + port1.sayHelloParams("myfile",buffer));
		//System.out.println("Server said: " + port1.sayHello("HOUSING"));
		
		
		System.out.println("Call Over!");
	}

}
