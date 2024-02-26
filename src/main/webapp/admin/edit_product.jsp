<%@page import="com.rkvermacode.Entity.ProductDetails"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add Product</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">

	<%@include file="navbar.jsp"%>

	<div class="container">

		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4 mb-4">
					<div class="card-body">
						<h4 class="text-center">Edit Product</h4>


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
						ProductDetails product = dao.getProductById(id);
						%>
						<form action="../edit_product" method="post"
							>
							<input type="hidden" name="id" value="<%=product.getId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Product Name*</label> <input
									name="name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=product.getName()%>" />
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Product Description*</label> <input
									name="description" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=product.getDescription()%>" />
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									value="<%=product.getPrice()%>" />
							</div>


							<div class="form-group">
								<label for="inputCategory">Product Category</label> <select
									id="inputCategory" name="category" class="form-control">
									<%
									if ("men".equalsIgnoreCase(product.getCategory())) {
									%>

									<option value="men">men</option>
									<option value="women">women</option>
									<option value="children">children</option>
									<%
									} else if ("women".equalsIgnoreCase(product.getCategory())) {
									%>
									<option value="women">women</option>
									<option value="men">men</option>
									<option value="children">children</option>
									<%
									} else {
									%>
									<option value="children">children</option>
									<option value="men">men</option>
									<option value="women">women</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="form-group">
								<label for="inputStatus">Product Status</label> <select
									id="inputStatus" name="status" class="form-control">
									<%
									if ("Active".equalsIgnoreCase(product.getStatus())) {
									%>

									<option value="Active">Active</option>
									<option value="InActive">Inactive</option>

									<%
									} else {
									%>
									<option value="InActive">Inactive</option>
									<option value="Active">Active</option>
									<%
									}
									%>


								</select>
							</div>

							

							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>