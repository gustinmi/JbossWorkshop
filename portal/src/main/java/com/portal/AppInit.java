package com.portal;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* test */
public class AppInit implements ServletContextListener {
	
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            Database database = Database.instance; //preload driver
        }
        catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }
	
}
