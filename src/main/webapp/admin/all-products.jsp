<%@page import="com.rkvermacode.Entity.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Products</title>
<%@include file="allCss.jsp"%>
</head>
<body>

	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello, Admin</h3>
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<c:if test="${not empty succMsg }">
		<h5 class="text-center text-success">${succMsg }</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<h5 class="text-center text-danger">${failedMsg }</h5>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<table class="table table-striped">
		<thead class="bg-info text-light">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Product Name</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Categories</th>
				<th scope="col">Status</th>
				<th scope="col">Image</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>

			<%
			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list = dao.getAllProducts();

			for (ProductDetails product : list) {
			%>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getDescription()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getCategory()%></td>
				<td><%=product.getStatus()%></td>
				<td><img alt="" src="../products/<%=product.getPhoto()%>"
					style="width: 45px; height: 45px;"></td>
				<td><a href="edit_product.jsp?id=<%=product.getId()%>"
					class="btn btn-sm btn-primary"><i class="fa-regular fa-pen-to-square"></i> Edit</a> <a
					href="../delete?id=<%=product.getId()%>"
					class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>