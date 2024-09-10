package com.example.webproject.service;

import com.example.webproject.model.User;
import com.example.webproject.repository.Repository;

import java.sql.SQLException;

public class Service {
    private Repository repository=new Repository();
    public boolean create(User user) throws SQLException{
        boolean saved=false;
        try {
            saved=repository.save(user);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }
    public User loginUser(String email) throws SQLException{
        return repository.findByEmail(email);
    }
}
