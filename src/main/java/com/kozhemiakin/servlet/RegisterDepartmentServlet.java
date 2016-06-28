package com.kozhemiakin.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterDepartment", urlPatterns = { "/RegisterDepartment" })
public class RegisterDepartmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into departments(depName) values(?)");
            ps.setString(1, name);
            ps.execute();

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/registerDepartment.jsp");
            PrintWriter out= resp.getWriter();
            out.println("<font color=green>Registration successful</font>");
            rd.include(req, resp);

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
