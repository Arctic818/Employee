package com.kozhemiakin.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "DeleteDepartment", urlPatterns = { "/DeleteDepartment/*" })
public class DeleteDepartmentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM departments WHERE depId=?");
            ps.setString(1, id);
            ps.execute();

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/SearchDepartment");
            rd.forward(req, resp);

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
