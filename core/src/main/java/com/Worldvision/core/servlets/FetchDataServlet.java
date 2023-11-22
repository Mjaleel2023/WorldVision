package com.Worldvision.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = { 
"sling.servlet.methods=" + HttpConstants.METHOD_GET,
"sling.servlet.paths=" + "/bin/fetch-data" })
public class FetchDataServlet extends SlingSafeMethodsServlet {


@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
    throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();

try {
    // Load the MySQL JDBC driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish a connection
    String url = "jdbc:mysql://localhost:3306/employee";
    String username = "root";
    String password = "admin";
    Connection connection = DriverManager.getConnection(url, username, password);

    // Prepare and execute the SQL query
    String sql = "SELECT * FROM emp1";
    try (PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

        // Display the fetched data
        
        response.getWriter().write("<h2> Data:</h2>");
        while (resultSet.next()) {
            // Modify the field names to match your table
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String address = resultSet.getString("address");

            // Display the data
            response.getWriter().write("First Name: " + firstName + "<br>");
            response.getWriter().write("Last Name: " + lastName + "<br>");
            response.getWriter().write("Address: " + address + "<br>");

            response.getWriter().write("<br>");
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to execute SQL query: " + e.getMessage());
    } finally {

        connection.close();
    }
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to establish database connection: " + e.getMessage());
}
}
}
