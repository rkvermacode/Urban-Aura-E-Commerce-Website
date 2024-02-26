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
import com.rkvermacode.Entity.ProductDetails;

@WebServlet("/edit_product")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditProductServlet() {
        super();
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			String productName = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String status = request.getParameter("status");
			
			ProductDetails pd = new ProductDetails();
			pd.setId(id);
			pd.setName(productName);
			pd.setDescription(description);
			pd.setPrice(price);
			pd.setCategory(category);
			pd.setStatus(status);
			
			
			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			boolean f = dao.editProduct(pd);
			
			HttpSession session = request.getSession();
			
			if(f) {
				
				session.setAttribute("succMsg", "Product Update Successfully...");
				response.sendRedirect("admin/all-products.jsp");
				
			}else {
				
				session.setAttribute("failedMsg", "Something wrong on server");
				response.sendRedirect("admin/all-products.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
