<%@page import="com.rkvermacode.Entity.Product_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductOrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Orders</title>
<%@include file="allCss.jsp"%>
</head>
<body>

	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<%@include file="navbar.jsp"%>
	<h3 class="text-center">Hello, Admin</h3>

	<table class="table table-striped">
		<thead class="bg-dark text-light">
			<tr>
				<th scope="col">Order ID</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Address</th>
				<th scope="col">Phone No</th>
				<th scope="col">Description</th>
				<th scope="col">Price</th>
				<th scope="col">Payment Type</th>
			</tr>
		</thead>
		<tbody>
			<%
			ProductOrderDAOImpl dao = new ProductOrderDAOImpl(DBConnection.getConnection());
			List<Product_Order> list = dao.getAllOrders();

			for (Product_Order p : list) {
			%>
			<tr>
				<td scope="row"><%=p.getOrderId()%></td>
				<td><%=p.getUserName()%></td>
				<td><%=p.getEmail()%></td>
				<td><%=p.getFullAddress()%></td>
				<td><%=p.getPhone()%></td>
				<td><%=p.getDescription()%></td>
				<td><%=p.getPrice()%></td>
				<td><%=p.getPaymentType()%></td>
			</tr>

			<%
			}
			%>


		</tbody>
	</table>

</body>
</html>