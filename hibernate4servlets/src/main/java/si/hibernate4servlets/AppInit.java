package si.hibernate4servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.hibernate.SessionFactory;
import si.hibernate4servlets.HibernateSessionFactory;

@WebListener
public class AppInit implements ServletContextListener {

    public Logger log = Logger.getLogger(this.getClass());
    
    @Override
    public void contextInitialized(ServletContextEvent arg0) {

        System.out.println("Application started");

        // load log4j file from classes folder
        DOMConfigurator.configure(this.getClass().getResource("/log4j.xml"));
        System.out.println("Log4j configured");

        // initialize hibernate with xml file
        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
        if (sessionFactory == null)
            throw new RuntimeException("Database not configure properly");
        
        System.out.println("Hibernate configured");

    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

}
