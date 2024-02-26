<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add Product</title>
<%@include file="allCss.jsp"%>
</head>
<body style="background-color: #f0f2f2;">

	<%@include file="navbar.jsp"%>
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp" />
	</c:if>

	<div class="container">

		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-4 mb-4">
					<div class="card-body">
						<h4 class="text-center">Add Product</h4>
						
						<c:if test="${not empty succMsg }">
						<p class="text-center text-success">${succMsg }</p>
						<c:remove var="succMsg" scope="session"/>
						</c:if>
						
						<c:if test="${not empty failedMsg }">
						<p class="text-center text-danger">${failedMsg }</p>
						<c:remove var="succMsg" scope="session"/>
						</c:if>

						<form action="../add_product" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label for="exampleInputEmail1">Product Name*</label> <input
									name="product-name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" />
							</div>
							
							<div class="form-group">
								<label for="exampleInputEmail1">Product Description*</label> <input
									name="description" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" />
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">Price*</label> <input
									name="price" type="number" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" />
							</div>


							<div class="form-group">
								<label for="inputCategory">Product Category</label> <select
									id="inputCategory" name="category" class="form-control">
									<option selected="selected">--select--</option>
									<option value="men">men</option>
									<option value="women">women</option>
									<option value="children">children</option>
								</select>
							</div>

							<div class="form-group">
								<label for="inputStatus">Product Status</label> <select
									id="inputStatus" name="status" class="form-control">
									<option selected="selected">--select--</option>
									<option value="Active">Active</option>
									<option value="InActive">Inactive</option>
								</select>
							</div>

							<div class="form-group">
								<label for="exampleFormControlFile1">Upload Photo</label> <input
									name="pimg" type="file" class="form-control-file"
									id="exampleFormControlFile1">
							</div>
							
							<button type="submit" class="btn btn-primary">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>