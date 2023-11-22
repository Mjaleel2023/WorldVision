package com.Worldvision.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = {
        "sling.servlet.methods=" + HttpConstants.METHOD_POST,
        "sling.servlet.paths=" + "/services/insert-data"
})
public class InsertDataServlet extends SlingAllMethodsServlet {

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String address = request.getParameter("address");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            String url = "jdbc:mysql://localhost:3306/employee";
            String username = "root";
            String password = "admin";
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare and execute the SQL query to insert data
            String sql = "INSERT INTO emp1 (employee_id, first_name, last_name, address) VALUES (?, ?, ?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                
                statement.setInt(1, employee_id);
                statement.setString(2, firstName);
                statement.setString(3, lastName);
                statement.setString(4, address);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to execute SQL query: " + e.getMessage());
            } finally {
                connection.close();
            }

            response.getWriter().write("<h2>Data inserted successfully!</h2>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to establish database connection: " + e.getMessage());
        }
    }
}
