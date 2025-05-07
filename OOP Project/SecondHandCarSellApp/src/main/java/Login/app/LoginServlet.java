package Login.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

     

        boolean success = LoginDB.saveUser(username, password); 

        if (success) {
            request.getRequestDispatcher("/Login/login_success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/Login/login_error.jsp").forward(request, response);
        }
    }
}
