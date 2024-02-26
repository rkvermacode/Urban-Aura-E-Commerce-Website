
<%@page import="com.rkvermacode.Entity.User"%>
<%@page import="com.rkvermacode.Entity.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Urban Aura</title>
<%@include file="components/allCss.jsp"%>
<style type="text/css">
.card-hover:hover {
	background-color: #f1f2f6;
	cursor: pointer;
}
</style>
</head>
<body style="background-color: #f7f7f7">

	<c:if test="${not empty addCart }">

		<div id="toast">${addCart}</div>

		<script type="text/javascript">
		showToast();
		function showToast(content)
		{
		    $('#toast').addClass("display");
		    $('#toast').html(content);
		    setTimeout(()=>{
		        $("#toast").removeClass("display");
		    },2000)
		}	
		</script>

		<c:remove var="addCart" scope="session" />
	</c:if>

	<%
	User user = (User) session.getAttribute("userobj");
	%>

	<%@include file="components/navbar.jsp"%>
	<%@include file="components/carousel.jsp"%>


	<!--start Recent Dress  -->
	<div class="container">
		<h3 class="text-center">Recent Product</h3>
		<div class="row">


			<%
			ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list = dao.getRecentProducts();

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

		<div class="text-center mt-1">
			<a href="all_recent_product.jsp"
				class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End Recent Dress -->

	<!--start Women's Dress  -->
	<div class="container">
		<h3 class="text-center">Women's Dress</h3>
		<div class="row">


			<%
			ProductDAOImpl dao2 = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list2 = dao.getWomenProducts();

			for (ProductDetails product2 : list2) {
			%>
			<div class="col-md-3">
				<div class="card card-hover">
					<div class="card-body text-center">
						<img alt="" src="products/<%=product2.getPhoto()%>"
							style="height: 200px" />
						<p>
							<strong style="color: #636e72;"><%=product2.getName()%></strong>
						</p>
						<p><%=product2.getDescription()%></p>
						<!--  <p>
							Categories:
							<%=product2.getCategory()%></p> -->
						<div class="row">
							<%
							if (user == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add
								Cart</a>

							<%
							} else {
							%>
							<a href="cart?pid=<%=product2.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-danger btn-sm ml-1">Add Cart</a>
							<%
							}
							%>
							<a href="view_product.jsp?id=<%=product2.getId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=product2.getPrice()%>
								<i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>



		</div>

		<div class="text-center mt-1">
			<a href="all_women_product.jsp"
				class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End Women's Dress -->

	<hr>

	<!--start men's Dress  -->
	<div class="container">
		<h3 class="text-center">Men's Dress</h3>
		<div class="row">


			<%
			ProductDAOImpl dao3 = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list3 = dao3.getMenProducts();

			for (ProductDetails product3 : list3) {
			%>
			<div class="col-md-3">
				<div class="card card-hover">
					<div class="card-body text-center">
						<img alt="" src="products/<%=product3.getPhoto()%>"
							style="height: 200px" />
						<p>
							<strong style="color: #636e72;"><%=product3.getName()%></strong>
						</p>
						<p><%=product3.getDescription()%></p>
						<!--  <p>
							Categories:
							<%=product3.getCategory()%></p> -->
						<div class="row">
							<%
							if (user == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add
								Cart</a>

							<%
							} else {
							%>
							<a href="cart?pid=<%=product3.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-danger btn-sm ml-1">Add Cart</a>
							<%
							}
							%>
							<a href="view_product.jsp?id=<%=product3.getId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=product3.getPrice()%>
								<i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>



		</div>

		<div class="text-center mt-1">
			<a href="all_men_product.jsp"
				class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End men's Dress -->

	<hr>

	<!--start children's Dress  -->
	<div class="container">
		<h3 class="text-center">Children's Dress</h3>
		<div class="row">


			<%
			ProductDAOImpl dao4 = new ProductDAOImpl(DBConnection.getConnection());
			List<ProductDetails> list4 = dao4.getChildrenProduct();

			for (ProductDetails product4 : list4) {
			%>
			<div class="col-md-3">
				<div class="card card-hover">
					<div class="card-body text-center">
						<img alt="" src="products/<%=product4.getPhoto()%>"
							style="height: 200px" />
						<p>
							<strong style="color: #636e72;"><%=product4.getName()%></strong>
						</p>
						<p><%=product4.getDescription()%></p>
						<!--  <p>
							Categories:
							<%=product4.getCategory()%></p> -->
						<div class="row">
							<%
							if (user == null) {
							%>
							<a href="login.jsp" class="btn btn-danger btn-sm ml-1">Add
								Cart</a>

							<%
							} else {
							%>
							<a href="cart?pid=<%=product4.getId()%>&&uid=<%=user.getId()%>"
								class="btn btn-danger btn-sm ml-1">Add Cart</a>
							<%
							}
							%>
							<a href="view_product.jsp?id=<%=product4.getId()%>"
								class="btn btn-success btn-sm ml-1">View Details</a> <a href=""
								class="btn btn-danger btn-sm ml-2"><%=product4.getPrice()%>
								<i class="fa-solid fa-indian-rupee-sign"></i></a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			%>



		</div>

		<div class="text-center mt-1">
			<a href="all_children_product.jsp"
				class="btn btn-danger btn-sm text-white">View All</a>
		</div>
	</div>
	<!-- End children's Dress -->

	<%@include file="components/footer.jsp"%>
</body>
</html>