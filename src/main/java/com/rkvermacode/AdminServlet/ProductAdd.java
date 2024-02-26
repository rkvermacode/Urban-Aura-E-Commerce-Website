package com.rkvermacode.AdminServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.rkvermacode.DAO.Impl.ProductDAOImpl;
import com.rkvermacode.DB.DBConnection;
import com.rkvermacode.Entity.ProductDetails;

@WebServlet("/add_product")
@MultipartConfig
public class ProductAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductAdd() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String productName = request.getParameter("product-name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String status = request.getParameter("status");
			Part part = request.getPart("pimg");
			String fileName = part.getSubmittedFileName();

			ProductDetails pd = new ProductDetails(productName, description, price, category, status, fileName,
					"admin@gmail.com");

			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			
			boolean f = dao.addProduct(pd);
			
			HttpSession session = request.getSession();
			
			
			if(f) {
				
				String path = getServletContext().getRealPath("")+ "products";
				File file = new File(path);
				part.write(path+ File.separator + fileName);
				
				session.setAttribute("succMsg", "Product Add Successfully...");
				response.sendRedirect("admin/add-product.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on Server...");
				response.sendRedirect("admin/add-product.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
