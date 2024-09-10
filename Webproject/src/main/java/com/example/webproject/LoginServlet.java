package com.example.webproject;

import com.example.webproject.model.User;
import com.example.webproject.service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    private Service service = new Service();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = service.loginUser(email);
            if (user != null && user.getPassword().equals(password)) {
                response.getWriter().println("<html><body>Welcome back, "+ user.getUsername()+"</body></html>");
            } else {
                response.getWriter().println("<html><body>Enter a valid username or password, try again</body></html>");
            }
        } catch (SQLException e) {
            response.sendRedirect("login.html?error=Internal error"); // Redirect to login page with error message
            e.printStackTrace();
        }
    }
}
