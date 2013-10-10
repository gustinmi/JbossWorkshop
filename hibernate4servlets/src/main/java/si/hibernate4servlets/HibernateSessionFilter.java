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
