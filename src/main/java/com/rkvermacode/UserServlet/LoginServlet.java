package com.rkvermacode.UserServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkvermacode.DAO.Impl.UserDAOImpl;
import com.rkvermacode.DB.DBConnection;
import com.rkvermacode.Entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			UserDAOImpl dao = new UserDAOImpl(DBConnection.getConnection());
			
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			if(email.equals("admin@gmail.com") && password.equals("admin")) {
				User user = new User();
				user.setName("Admin");
				session.setAttribute("userobj", user);
				response.sendRedirect("admin/home.jsp");
			} else {
				
				User user = dao.login(email, password);
				if(user!=null) {
					session.setAttribute("userobj", user);
					response.sendRedirect("index.jsp");
				} else {
					session.setAttribute("failedMsg", "Email & Password Invalid");
					response.sendRedirect("login.jsp");
				}
				
			}
			
		} catch (Exception e) {
			
		}
	}

}
