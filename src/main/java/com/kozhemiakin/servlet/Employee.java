package com.kozhemiakin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/reg")
public class Employee extends HttpServlet{

    private static Connection conn;
    private static Statement stmt;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String JDBC_DRIVER="com.mysql.jdbc.Driver";
        final String DB_URL ="jdbc:mysql://localhost/test2016";
        final String USER = "root";
        final String PASS = "root";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT empid, empAge FROM employee";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                int id  = rs.getInt("empid");
                int age = rs.getInt("empAge");

                out.println("ID: " + id + "<br>");
                out.println(", Age: " + age + "<br>");

            }
            out.println("</body></html>");

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally {
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        } //end try
    }
}