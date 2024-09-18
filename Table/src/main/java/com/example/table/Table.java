package com.example.table;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

public class Table extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("get method");
         Connection connection=null;
         try {
             connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root","1357");
         }catch (SQLException e){
             System.out.println(e.getMessage());
         }

         try(Statement statement=connection.createStatement()){
             ResultSet resultSet=statement.executeQuery("select * from myDB.passenger");
             response.getWriter().println(
                     "<html>" +
                             "<head>" +
                             "<title>Data Table</title>" +
                             "<style>"+
                             "table{border-collapse: collapse;}"+
                             "</style>"+
                             "</head>" +
                             "<body>" +
                             "<form method='post' action='/submit'> "+
                             "<table border='1'>" +
                             "<thead>" +
                             "<tr>" +
                             "<th>Name</th>" +
                             "<th>ID</th>" +
                             "<th>Age</th>" +
                             "<th>Route</th>" +
                             "</tr>" +
                             "</thead>" +
                             "<tbody>"

             );

             while (resultSet.next()) {
                 response.getWriter().println(
                         "<tr>" +
                                 "<td contenteditable>" +"<input type='text' name='name' value="+resultSet.getString("name")+">"+"</td>" +
                                 "<td >" +"<input type='text' name='id' value='"+resultSet.getString("id")+"' readonly></td>" +
                                 "<td contenteditable>" +"<input type='text' name='age' value="+resultSet.getString("age")+">"+"</td>" +
                                 "<td contenteditable>" +"<input type='text' name='route' value="+resultSet.getString("route")+">"+"</td>" +
                                 "</tr>"
                 );
             }

             response.getWriter().println(
                     "</tbody>" +
                             "</table>" +
                             "<input type='submit' value='update'>"+
                             "</form>"+
                             "</body>" +
                             "</html>"
             );

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

    }
}
