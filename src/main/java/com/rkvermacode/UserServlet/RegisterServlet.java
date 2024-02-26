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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			String checkbox = request.getParameter("checkbox");
			
//			System.out.println(name+" "+email+" "+phone+" "+password+" "+checkbox);
			
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);
			
			HttpSession session = request.getSession();
			
			if(checkbox!=null) {
				
				UserDAOImpl dao = new UserDAOImpl(DBConnection.getConnection());
				
				boolean checkUser = dao.checkUser(email);
				
				if(checkUser) {
					
					boolean f = dao.userRegister(user);
					
					if(f) {
						session.setAttribute("succMsg", "Register successfully...");
						response.sendRedirect("register.jsp");
					} else {
						session.setAttribute("failedMsg", "Somethong wrong on Server");
						response.sendRedirect("register.jsp");
					}
					
				} else {
					session.setAttribute("failedMsg", "User Already Exit Try Another Email");
					response.sendRedirect("register.jsp");
				}
				
				
				
			} else {
				session.setAttribute("failedMsg", "Please check Agree Terms & Conditions");
				response.sendRedirect("register.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
