package si.hibernate4servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/** Open session in view pattern. Current session is bound to thread.
 * Must be configured in hibernate.cfg as well.
 * @see Hibernate Recipes, page 263 */
@WebFilter(filterName="filter2", urlPatterns={"/*"})
public class HibernateSessionFilter implements Filter {

    protected final Logger log = Logger.getLogger(this.getClass());

    public void destroy() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
        
    }

    /**
     *  Wrapper for begin and close transaction
    */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session currentHbmSession = null;
        try {
            log.trace("Opening hbm session");
            
            // If you set hibernate.current_session_context_class to thread and then implement something like
            // a servlet filter that opens the session then you can access that session anywhere else by using
            // the SessionFactory.getCurrentSession().
            // You should never use "one session per web app" - session is not a thread safe object - cannot be shared by multiple threads.
            // You should always use "one session per request" or "one session per transaction"
            
            //DO NOT USE !!!!!!  HibernateUtil.getSessionFactory().openSession(); Session is already opened
            
            currentHbmSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();

            log.trace("Begginging hbm transaction");
            currentHbmSession.beginTransaction();

            // execute filter chain
            chain.doFilter(request, response);

            currentHbmSession.getTransaction().commit();

        } catch (HibernateException e) {
            log.error(e.getMessage(), e);
            if (currentHbmSession.getTransaction().isActive()) {
                currentHbmSession.getTransaction().rollback();
            }
            throw new ServletException("Napaka pri povezavi do baze podatkov", e);
        }

        return;
    }

}
