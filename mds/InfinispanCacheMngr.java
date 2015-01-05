import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.infinispan.manager.CacheContainer;

public class InfinispanCacheMngr {

	static CacheContainer container = null;

	public static CacheContainer getCacheContainer() {
		if(container == null) {
			try {
				Context ctx = new InitialContext();
				container = (CacheContainer) ctx.lookup("java:jboss/infinispan/container/mycache");
				container.start();
			} catch (NamingException e) {
				e.getCause();
			}
		}
		return container;
	}

	public static Object add(String key){
		return getCacheContainer().getCache().get(key);
	}

	public static void add(String key, Object value){
		getCacheContainer().getCache().put(key, value);
}

}