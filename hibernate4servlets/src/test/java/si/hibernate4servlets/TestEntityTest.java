package si.hibernate4servlets;

import static org.junit.Assert.*;
import static si.hibernate4servlets.GenericDAOImpl.*;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

public class TestEntityTest {

    final Logger log = Logger.getLogger(this.getClass());
    
    @Test
    public void test() {
        Session currentHbmSession = null;
        try {
            log.trace("Opening hbm session");
            currentHbmSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();

            log.trace("Begginging hbm transaction");
            currentHbmSession.beginTransaction();
            
            TestEntity myEntity = mngr_TestTable.find(Restrictions.eq("id", 312));
            System.out.print(myEntity.getId());    
            
            currentHbmSession.getTransaction().commit();

        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            if (currentHbmSession.getTransaction().isActive()) {
                currentHbmSession.getTransaction().rollback();
            }
            fail("Napaka pri povezavi do baze podatkov");
        }

        return;
    }

}
