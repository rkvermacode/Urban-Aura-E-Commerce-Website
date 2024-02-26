<%@page import="com.rkvermacode.Entity.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.Entity.User"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.CartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart: Urban Aura</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f7f7f7">

	<%@include file="components/navbar.jsp"%>

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<c:if test="${not empty succMsg }">
		<div class="alert alert-success" role="alert">${succMsg }</div>
		<c:remove var="succMsg" scope="session" />
	</c:if>

	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger text-center" role="alert">${failedMsg }</div>
		<c:remove var="failedMsg" scope="session" />
	</c:if>

	<div class="container">

		<div class="row p-2">
			<div class="col-md-6">


				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Product Name</th>
									<th scope="col">Description</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userobj");

								CartDAOImpl dao = new CartDAOImpl(DBConnection.getConnection());
								List<Cart> cart = dao.getProductByUser(user.getId());
								double totalPrice = 0;
								for (Cart c : cart) {
									totalPrice = c.getTotal_price();
								%>
								<tr>
									<th scope="row"><%=c.getProductName()%></th>
									<td><%=c.getDescription()%></td>
									<td><%=c.getPrice()%></td>
									<td><a
										href="remove_product?pid=<%=c.getPid()%>&&uid=<%=c.getUserId()%>&&cid=<%=c.getCid()%>"
										class="btn btn-sm btn-danger">Remove</a></td>
								</tr>


								<%
								}
								%>

								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td><%=totalPrice%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">Your Details for Order</h3>
						<form action="order" method="post">
						<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										class="form-control" id="inputEmail4"
										value="<%=user.getName()%>" readonly="readonly" name="name">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										class="form-control" id="inputPassword4"
										value="<%=user.getEmail()%>" readonly="readonly" name="email">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Mobile</label> <input type="number"
										class="form-control" id="inputEmail4"
										value="<%=user.getPhone()%>" name="phone" required="required">
								</div>
								<div class="form-group col-md-6">
									<label>Address</label> <input type="text"
										class="form-control" name="address" required="required">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										class="form-control" id="inputEmail4" name="landmark" required="required">
								</div>
								<div class="form-group col-md-6">
									<label >City</label> <input type="text"
										class="form-control"  name="city" required="required">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label >State</label> <input type="text"
										class="form-control" name="state" required="required">
								</div>
								<div class="form-group col-md-6">
									<label>Zip</label> <input type="number" class="form-control"
										name="zipcode" required="required">
								</div>
							</div>

							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control" name="paymentType">
									<option value="noselect">--select--</option>
									<option value="COD">Cash on Delivery</option>
								</select>
							</div>

							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>