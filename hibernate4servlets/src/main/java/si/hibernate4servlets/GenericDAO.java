package si.hibernate4servlets;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

/**
 * Based on http://community.jboss.org/docs/DOC-13955
 */
public abstract class GenericDAO<T, ID extends Serializable> extends HibernateSessionFactory {

    private Class<T> persistentClass;

    protected Logger log = Logger.getLogger(GenericDAO.class);

    @SuppressWarnings({ "unchecked" })
    public GenericDAO() {
        try {
            persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (ClassCastException e) {
            // can be raised when DAO is inherited twice
            persistentClass = (Class<T>) ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findByNamedQuery(String namedQueryName, Map<String, Object> args) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Query query = hibernateSession.getNamedQuery(namedQueryName);
        if (args != null && args.entrySet().size() > 0) {
            Iterator<Entry<String, Object>> iterator = args.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> next = iterator.next();
                query.setParameter(next.getKey().toString(), next.getValue());
            }
        }

        query.setCacheable(true);
        query.setCacheRegion("queryRegion");

        List<T> list = query.list();
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByNativeQuery(String nativeQueryName, Map<String, Object> args) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        Query query = hibernateSession.createSQLQuery(nativeQueryName);
        if (args != null && args.entrySet().size() > 0) {
            Iterator<Entry<String, Object>> iterator = args.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> next = iterator.next();
                query.setParameter(next.getKey().toString(), next.getValue());
            }
        }
        List<T> list = query.list();
        return list;
    }

    @SuppressWarnings("unchecked")
    public T findById(Serializable id, boolean lock) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        T entity;
        if (lock) {
            entity = (T) hibernateSession.get(persistentClass, id, LockMode.PESSIMISTIC_WRITE);
        } else {
            entity = (T) hibernateSession.get(persistentClass, id);
        }
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        DetachedCriteria crit = DetachedCriteria.forClass(persistentClass);
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        Criteria criteria = crit.getExecutableCriteria(hibernateSession);
        return criteria.list();
    }

    public T save(T entity) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        hibernateSession.save(entity);
        hibernateSession.flush();
        return entity;
    }

    public T update(T entity) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        hibernateSession.update(entity);
        return entity;
    }
    
    public void batchInsert(List<T> list) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            hibernateSession.saveOrUpdate(element);
            if (i % 50 == 0) { // 50, same as the JDBC batch size set in hibernate.cfg
                // flush a batch of inserts and release memory:
                hibernateSession.flush();
                hibernateSession.clear();
            }
        }
        return;
    }

    public void delete(T entity) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        hibernateSession.delete(entity);
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findAll(Criterion... detachedCriterias) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        DetachedCriteria crit = DetachedCriteria.forClass(persistentClass);
        for (Criterion c : detachedCriterias) {
            crit.add(c);
        }
        Criteria criteria = crit.getExecutableCriteria(hibernateSession);
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public T find(Criterion... detachedCriterias) {
        Session hibernateSession = HibernateSessionFactory.getSessionFactory().getCurrentSession();
        DetachedCriteria crit = DetachedCriteria.forClass(persistentClass);
        for (Criterion c : detachedCriterias) {
            crit.add(c);
        }
        Criteria criteria = crit.getExecutableCriteria(hibernateSession);
        return (T) criteria.uniqueResult();
    }

}