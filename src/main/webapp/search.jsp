<%@page import="com.rkvermacode.Entity.User"%>
<%@page import="com.rkvermacode.Entity.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="components/allCss.jsp"%>
</head>
<body>

	<%
	User user = (User) session.getAttribute("userobj");
	%>

	<%@include file="components/navbar.jsp"%>

	<!--start Recent Dress  -->
	<div class="container mt-3 mb-3">
		<div class="row">
			<%
			String characters = request.getParameter("characters");
			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list = dao.searchProducts(characters);

			for (ProductDetails product : list) {
			%>
			<div class="col-md-3">
				<div class="card card-hover">
					<div class="card-body text-center">
						<img alt="" src="products/<%=product.getPhoto()%>"
							style="height: 200px" />
						<p>
							<strong style="color: #636e72;"><%=product.getName()%></strong>
						</p>
						<p><%=product.getDescription()%></p>
						<!--  <p>
							Categories:
							<%=product.getCategory()%></p> -->
						<div class="row">
							<%
							if (user == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add
								Cart</a>

							<%
							} else {
							%>
							<a href="cart?pid=<%=product.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-danger btn-sm ml-1">Add Cart</a>
							<%
							}
							%>

							<a href="view_product.jsp?id=<%=product.getId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=product.getPrice()%> <i
								class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<!-- End Recent Dress -->

</body>
</html>