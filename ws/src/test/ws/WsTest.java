package ws;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ws.client.HelloWorld;
import com.ws.client.HelloWorldService;

public class WsTest {

	@Test
	public void test() {
		
	
	        System.out.println("***********************");
	        System.out.println("Create Web Service Client...");
	        HelloWorldService service1 = new HelloWorldService();
	        System.out.println("Create Web Service...");
	        HelloWorld port1 = service1.getHelloWorldPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port1.sayHello(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port1.initJob(null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Create Web Service...");
	        HelloWorld port2 = service1.getHelloWorldPort();
	        System.out.println("Call Web Service Operation...");
	        System.out.println("Server said: " + port2.sayHello(null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("Server said: " + port2.initJob(null,null));
	        //Please input the parameters instead of 'null' for the upper method!
	
	        System.out.println("***********************");
	        System.out.println("Call Over!");
		    
	}

}
