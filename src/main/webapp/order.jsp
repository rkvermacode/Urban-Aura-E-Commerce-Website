<%@page import="com.rkvermacode.DAO.Impl.ProductOrderDAOImpl"%>
<%@page import="com.rkvermacode.Entity.Product_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@page import="com.rkvermacode.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<div class="container p-1">
		<h3 class="text-center text-primary">Your Orders</h3>
		<table class="table table-striped mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Mode</th>
				</tr>
			</thead>
			<tbody>
				<%
				User user = (User) session.getAttribute("userobj");
				ProductOrderDAOImpl dao = new ProductOrderDAOImpl(DBConnection.getConnection());
				List<Product_Order> list = dao.getProduct(user.getEmail());

				for (Product_Order p : list) {
				%>
				<tr>
					<th scope="row"><%=p.getOrderId()%></th>
					<td><%=p.getProductName()%></td>
					<td><%=p.getDescription()%></td>
					<td><%=p.getPrice()%></td>
					<td><%=p.getPaymentType()%></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</div>
</body>
</html>