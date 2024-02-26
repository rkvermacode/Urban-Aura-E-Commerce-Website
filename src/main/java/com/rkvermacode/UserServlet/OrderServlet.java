package com.rkvermacode.UserServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rkvermacode.DAO.ProductOrderDAO;
import com.rkvermacode.DAO.Impl.CartDAOImpl;
import com.rkvermacode.DAO.Impl.ProductDAOImpl;
import com.rkvermacode.DAO.Impl.ProductOrderDAOImpl;
import com.rkvermacode.DB.DBConnection;
import com.rkvermacode.Entity.Cart;
import com.rkvermacode.Entity.Product_Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();

			int id = Integer.parseInt(request.getParameter("id"));

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String landmark = request.getParameter("landmark");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zipcode = request.getParameter("zipcode");
			String paymentType = request.getParameter("paymentType");

			String fullAddress = address + "," + landmark + "," + city + "," + state + "," + zipcode;

			CartDAOImpl dao = new CartDAOImpl(DBConnection.getConnection());
			List<Cart> productList = dao.getProductByUser(id);

			if (productList.isEmpty()) {
				session.setAttribute("failedMsg", "Add Item");
				response.sendRedirect("cart.jsp");

			} else {

				ProductOrderDAO dao2 = new ProductOrderDAOImpl(DBConnection.getConnection());

				Product_Order productOrder = null;

				ArrayList<Product_Order> orderList = new ArrayList<Product_Order>();
				Random r = new Random();
				for (Cart c : productList) {

					productOrder = new Product_Order();

					productOrder.setOrderId("P-ORD-0" + r.nextInt(1000));
					productOrder.setUserName(name);
					productOrder.setEmail(email);
					productOrder.setPhone(phone);
					productOrder.setFullAddress(fullAddress);
					productOrder.setProductName(c.getProductName());
					productOrder.setDescription(c.getDescription());
					productOrder.setPrice(c.getPrice() + "");
					productOrder.setPaymentType(paymentType);

					orderList.add(productOrder);
				}

				if ("noselect".equals(paymentType)) {
					session.setAttribute("failedMsg", "Please Choose Payment Method");
					response.sendRedirect("cart.jsp");
				} else {

					boolean f = dao2.saveOrder(orderList);

					if (f) {
						response.sendRedirect("order_success.jsp");
					} else {
						session.setAttribute("failedMsg", "Your Order Failed");
						response.sendRedirect("cart.jsp");
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
