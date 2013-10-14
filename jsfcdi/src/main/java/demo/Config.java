package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 * 
 * 
 * Caused by: org.jboss.weld.exceptions.DeploymentException: 
 * WELD-001409 Ambiguous dependencies for type [Config] with qualifiers [@Default] at injection point [[field] @Inject private demo.Common.config]. 
 * Possible dependencies:
 *   1 [[Producer Method [Config] with qualifiers [@Any @Default @Named] declared as [[method] @Produces @Default @Named @ApplicationScoped public static demo.Config.getConfig()],
 *   2 Managed Bean [class demo.Config] with qualifiers [@Any @Default]]]
 * 
 * 
 * 
 * @author mitja
 *
 */

@SkipInjection
public class Config {
	
	@Produces @Default @Named("configBean") @ApplicationScoped
	public static Config getConfig() {
		return new Config();		
	}
	
	private Properties properties;

	public Config() {
		
		//load property file
		
		InputStream is = null;
		try {
			properties = new Properties();
			is = getClass().getResourceAsStream("/properties.xml");
			properties.loadFromXML(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try	{ if(is != null) is.close(); } catch(IOException e) {} //do just nothing
		}
		
		// access the values 
		// final String first = getString("some.key", "not known");
		// final String environmentType = getString("some.other", "not known");
		
		
	}
	
	public int getInt(String key,int def) {
		String val = properties.getProperty(key);
		if (val==null) return def;
		return Integer.parseInt(val);
	}
	
	public String getString(String key,String def) {
		String val = properties.getProperty(key);
		if (val==null) return def;
		else return val;		
	}
	
}
