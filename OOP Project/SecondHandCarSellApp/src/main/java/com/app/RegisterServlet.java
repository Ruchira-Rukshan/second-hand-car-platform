package com.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/components/user")

public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String regName = request.getParameter("regName");
        String regEmail = request.getParameter("regEmail");
        String regContact = request.getParameter("regContact");
        String regRole = request.getParameter("regRole");
        String password = request.getParameter("password");

     
		boolean success = RegisterDB.saveUser(regName, regEmail,regContact,regRole,password);

        if (success) {
        	request.getRequestDispatcher("/Register/register_success.jsp").forward(request, response);

        } else {
        	request.getRequestDispatcher("/Register/register_error.jsp").forward(request, response);



        }
    }
	
	
}

