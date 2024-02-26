package com.rkvermacode.UserServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkvermacode.DAO.Impl.CartDAOImpl;
import com.rkvermacode.DAO.Impl.ProductDAOImpl;
import com.rkvermacode.DB.DBConnection;
import com.rkvermacode.Entity.Cart;
import com.rkvermacode.Entity.ProductDetails;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			int pid = Integer.parseInt(request.getParameter("pid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			
			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			ProductDetails product = dao.getProductById(pid);
			
			Cart cart = new Cart();
			cart.setPid(pid);
			cart.setUserId(uid);
			cart.setProductName(product.getName());
			cart.setDescription(product.getDescription());
			cart.setPrice(Double.parseDouble(product.getPrice()));
			cart.setTotal_price(Double.parseDouble(product.getPrice()));
			
			CartDAOImpl dao2 = new CartDAOImpl(DBConnection.getConnection());
			boolean f = dao2.addCart(cart);
			
			HttpSession session = request.getSession();
			
			if(f) {
				session.setAttribute("addCart", "Product Added to the Cart");
				response.sendRedirect("index.jsp");
				
			} else {
				session.setAttribute("failed", "Something wrong on server");
				response.sendRedirect("index.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
