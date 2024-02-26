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

@WebServlet("/update_profile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateProfile() {
        super();
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String password = request.getParameter("password");
			
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			
			UserDAOImpl dao = new UserDAOImpl(DBConnection.getConnection());
			boolean f = dao.checkPassword(id, password);
			
			HttpSession session = request.getSession();
			
			if(f) {
				
				boolean f2 = dao.updateProfile(user);
				if(f2) {
					
					session.setAttribute("succMsg", "Profile Update Successfully...");
					response.sendRedirect("edit_profile.jsp");
					
				} else {
					
					session.setAttribute("failedMsg", "Something wrong on server");
					response.sendRedirect("edit_profile.jsp");
					
				}
				
			} else {
				
				session.setAttribute("failedMsg", "Your Password is Incorrect");
				response.sendRedirect("edit_profile.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
