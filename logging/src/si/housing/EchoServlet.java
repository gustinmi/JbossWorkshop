package si.housing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.*;


@WebServlet("/EchoServlet")
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(EchoServlet.class);	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//log.debug(test);
		//log.info("info log");
		//log.warn("warn log");
		
		 response.setContentType("text/plain;charset=UTF-8");
         final PrintWriter out = response.getWriter();
         out.print(NavadnaBaza.instance.get());
         out.flush();
         return;
	}

}
