package si.hibernate4servlets;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/** This is database configuration for application level. For communication with database we use
 * framework hibernate, version 3.3. The framework is configured with external configuration file. The
 * file is located at: src/main/resources/hibernate.cfg.xml.
 * @author mitja */
public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
