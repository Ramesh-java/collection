package com.example.webproject.repository;

import com.example.webproject.model.User;

import java.sql.*;

public class Repository {
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1357");
    }

    public boolean save(User user) throws SQLException{
        Connection connection=null;
        try {
            connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO user.details ( username,email, password) VALUES (?, ?, ?)");
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            int rowSinserted=preparedStatement.executeUpdate();
            if (rowSinserted>0){
                return true;
            }
        }
        finally {
            if (connection!=null){
                connection.close();
            }
        }
        return false;

    }

    public User findByEmail(String email) throws SQLException{
        Connection connection=null;
        try {
            connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM user.details WHERE email = ?");
        preparedStatement.setString(1,email);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            User user=new User();
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        finally {
            if (connection!=null){
                connection.close();
            }
        }
        return null;
    }
}
