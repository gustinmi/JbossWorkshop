package demo;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named
public class MySingleton {

	@PostConstruct
	public void initBean() {
	}
	
	public String getSomeValue() {
		return "from singleton";
	}
	
	
}
