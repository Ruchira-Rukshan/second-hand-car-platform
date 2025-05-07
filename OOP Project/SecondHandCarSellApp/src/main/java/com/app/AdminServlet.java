package com.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/components/admin")
public class AdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            boolean success = RegisterDB.deleteUserByEmail(email);
            response.getWriter().write(success ? "User deleted." : "User not found.");
        }

        else if ("update".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String role = request.getParameter("role");
            String password = request.getParameter("password");

            User updatedUser = new User(name, email, contact, role, password);
            boolean success = RegisterDB.updateUser(updatedUser);
            response.getWriter().write(success ? "User updated." : "User not found.");
        }

        else if ("search".equalsIgnoreCase(action)) {
            String email = request.getParameter("email");
            List<User> users = RegisterDB.getAllUsers();
            for (User user : users) {
                if (user.getEmail().equalsIgnoreCase(email)) {
                    response.getWriter().write(user.toString());
                    return;
                }
            }
            response.getWriter().write("User not found.");
        }

        else {
            response.getWriter().write("Invalid action.");
        }
    }
}
