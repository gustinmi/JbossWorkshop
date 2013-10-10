package si.hibernate4servlets;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	@Test
	public void test() {
	
		/**
		 * 
		 *  REDIS CLIENT Redis is key value store (twitter)
		 *  
		 *  ubuntu:
		 *  sudo apt-get install redis-server
		 *  sudo service redis-server start
		 * 
		 * using simple key-value in-memory and persistent database (NOSQL database variation)
		 * @see http://redis.io/commands
		 * @see https://github.com/xetorthio/jedis
		 *
		 * Sample session:
		 * 
		 * /usr/local/bin/redis-server    This is main executable
		 *	/usr/local/etc/redis.conf       This is configuration
		 *	
		 *	Using CLI interface
		 *	redis-cli -h localhost
		 *	Primer ukazov (kako gledat kaj se zapisuje realtime)
		 *	redis-cli -h localhost monitor | grep some_key
		 * 
		 *  redis> GET nonexisting
		 *		(nil)
		 *	redis> SET mykey "Hello"
		 *		OK
		 *	redis> GET mykey
		 *		"Hello"
		 *	redis> 
		*/
		
		
		try{
			Jedis jedis = new Jedis("localhost"); // new Jedis(host, port);
			jedis.set("foo", "bar");
			String value = jedis.get("foo");
			assertEquals("bar", value);
			
			Map<String, String> hash = new HashMap<String, String>();
			hash.put("data", "someValue");

			String status = jedis.hmset("foo", hash);
			assertEquals("OK", status);
			assertEquals(hash, jedis.hgetAll("foo"));
			
		}catch(Exception ex){
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	
	}

}
