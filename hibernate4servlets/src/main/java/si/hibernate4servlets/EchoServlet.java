package si.hibernate4servlets;

import static si.hibernate4servlets.GenericDAOImpl.mngr_TestTable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;

@WebServlet(name = "EchoServlet", urlPatterns = { "/Echo" })
public class EchoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(EchoServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            final String pId = request.getParameter("id");
            final Integer id;
            if (null != pId) { id = Integer.parseInt(pId);} else {id = null;}
            TestEntity myEntity = mngr_TestTable.findById(id, false);
            final String jsonStr = "{ \"id\":\"" + myEntity.getId() +"\", \"name\": \"" + myEntity.getName() + "\"}";
            log.info("Servlet finished processing");
            response.setContentType("application/json;charset=UTF-8");
            final PrintWriter out = response.getWriter();
            out.print(jsonStr);
            out.flush();
            return;
        } catch (Exception ex) {
            log.error("Error while processing request:", ex);
            noData(response);
            return;
        }
    }

    private void noData(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{ \"name\":\"error\", \"code\": 1}");
        out.flush();
        return;
    }

}
