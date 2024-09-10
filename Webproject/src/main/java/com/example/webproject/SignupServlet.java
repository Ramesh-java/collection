package com.example.webproject;

import com.example.webproject.model.User;
import com.example.webproject.service.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class SignupServlet extends HttpServlet {
    private Service service = new Service();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        try {
            boolean userCreated=service.create(user);

            if (userCreated){
                response.sendRedirect("login.html");
            }
            else {
                response.getWriter().println("<html><body>User with "+email+" already exist</body></html>");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            response.sendRedirect("signup.html?error=Internal error"); // Redirect to signup page with error message
        }
    }
}
