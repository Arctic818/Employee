package com.kozhemiakin.servlet;

import com.kozhemiakin.domain.Department;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "SearchDepartmentServlet", urlPatterns = { "/SearchDepartment" })
public class SearchDepartmentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection con = (Connection) getServletContext().getAttribute("DBConnection");
        Statement st = null;
        Set<Department> departments = new HashSet<Department>();

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM test2016.departments");

            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                Department dep = new Department(id, name);
                departments.add(dep);
            }

            req.setAttribute("departments", departments);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/pages/managerDepartment.jsp");
            rd.forward(req, resp);


        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
