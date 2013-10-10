package si.hibernate4servlets;

import si.hibernate4servlets.GenericDAO;

/**
 * Proxies for all standard CRUD operations 
 */
public class GenericDAOImpl {

    public static GenericDAOImpl.TestTableManager mngr_TestTable = new GenericDAOImpl.TestTableManager();
    
    public static class TestTableManager extends GenericDAO<TestEntity, Integer> {}

    
}
