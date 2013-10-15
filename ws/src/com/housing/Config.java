package com.housing;

import javax.inject.Named;

@Named("cfg")
public class Config {

	private final boolean isDebug;
	
	public Config() {
		isDebug = true;	
	}

	public boolean isDebug() {
		return isDebug;
	}
	
	
}
