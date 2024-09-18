    package com.example.table;

    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;


    public class Submit extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
            Connection connection;
            try {
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB","root","1357");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String[] names=request.getParameterValues("name");
            String[] id=request.getParameterValues("id");
            String[] age=request.getParameterValues("age");
            String[] route=request.getParameterValues("route");
            int i=0;
            while (i<names.length) {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("update myDB.passenger set name=?,age=?,route=? where id=" + id[i] + "");
                    preparedStatement.setString(1, names[i]);
                    preparedStatement.setString(2, age[i]);
                    preparedStatement.setString(3, route[i]);
                    i++;
                    int rowsUpdated=preparedStatement.executeUpdate();
                    if (rowsUpdated!=0){
                        System.out.println("updated");
                    }else {
                        System.out.println("never");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            response.sendRedirect("/table");


        }
    }
