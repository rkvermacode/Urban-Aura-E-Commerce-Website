<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Settings</title>
<%@include file="components/allCss.jsp"%>

<style type="text/css">
a {
	text-decoration: none;
	color: black;
}

a:hover {
	text-decoration: none;
	color: black;
}
</style>

</head>
<body style="background-color: #f7f7f7">

	<%@include file="components/navbar.jsp"%>
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<div class="container">
		<c:if test="${not empty userobj }">
			<h3 class="text-center m-5">Hello, ${userobj.name }</h3>
		</c:if>
		<div class="row">

			<div class="col-md-4">
				<a href="order.jsp">
					<div class="card">

						<div class="card-body text-center">
							<i class="fa-solid fa-box-open fa-3x text-danger"></i> <br />
							<h4>My Order</h4>
							<p>Track Your Order</p>
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="helpline.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-circle-user fa-3x text-secondary"></i> <br />
							<h4>Help Center</h4>
							<p>24x7 Service</p>
						</div>
					</div>
				</a>
			</div>



			<div class="col-md-4">
				<a href="edit_profile.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-address-card fa-3x text-primary"></i> <br />
							<h4>Edit Profile</h4>
							<p>---------</p>
						</div>
					</div>
				</a>
			</div>
		</div>
	</div>

</body>
</html>