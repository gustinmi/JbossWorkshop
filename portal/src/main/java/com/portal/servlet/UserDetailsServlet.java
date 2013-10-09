package com.portal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.portal.Database;

@WebServlet(name = "UserDetailsServlet", urlPatterns = { "/UserDetails" })
public class UserDetailsServlet extends HttpServlet  {
    private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String jsonStr = Database.instance.getUserDetails();
            if (null != jsonStr) {
                jsonStr = "{\"status\":\"ok\",\"data\": " + jsonStr  + " }";
            }
            response.setContentType("application/json;charset=UTF-8");
            final PrintWriter out = response.getWriter();
            out.print(jsonStr);
            out.flush();
            return;
        } catch (Exception ex) {
            noData(response);
            return;
        }
    }

    private void noData(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        final PrintWriter out = response.getWriter();
        out.print("{\"status\":\"err\",\"msg\":\"Napaka pri komunikaciji!\"}");
        out.flush();
        return;
    }

}
