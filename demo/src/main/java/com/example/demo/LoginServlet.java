package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/Submit")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String department = request.getParameter("department");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>"+username+"</body></html>");

        System.out.println("name :"+username+"\nage :"+age+"\ndepartment :"+department);
        Connection connection=null;
        try {
            String url = "jdbc:mysql://localhost:3306/myDB";
            String jusername = "root";
            String password = "1357";
            connection= DriverManager.getConnection(url,jusername,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        String query="insert into myDB.submit(name,age,department)values (?,?,?)";
        try (PreparedStatement pr=connection.prepareStatement(query)){
            pr.setString(1,username);
            pr.setInt(2,age);
            pr.setString(3,department);
            int rowsinserted=pr.executeUpdate();
            if (rowsinserted>0){
                System.out.println("inserted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
