package com.rkvermacode.AdminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkvermacode.DAO.Impl.ProductDAOImpl;
import com.rkvermacode.DB.DBConnection;

@WebServlet("/delete")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int id = Integer.parseInt(request.getParameter("id"));

			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			boolean f = dao.deleteProduct(id);

			HttpSession session = request.getSession();

			if (f) {

				session.setAttribute("succMsg", "Product Delete Successfully...");
				response.sendRedirect("admin/all-products.jsp");

			} else {

				session.setAttribute("failedMsg", "Something wrong on server");
				response.sendRedirect("admin/all-products.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
