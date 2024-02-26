package com.rkvermacode.UserServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkvermacode.DAO.Impl.CartDAOImpl;
import com.rkvermacode.DB.DBConnection;

@WebServlet("/remove_product")
public class RemoveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveProduct() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		CartDAOImpl dao = new CartDAOImpl(DBConnection.getConnection());
		
		boolean f = dao.deleteProduct(pid, uid,cid);
		
		HttpSession session = request.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "Product Removed Successfully...");
			response.sendRedirect("cart.jsp");
		} else {
			session.setAttribute("failedMsg", "Something wrong on server");
			response.sendRedirect("cart.jsp");
		}

	}

}
