
<%@page import="com.rkvermacode.Entity.ProductDetails"%>
<%@page import="com.rkvermacode.DB.DBConnection"%>
<%@page import="com.rkvermacode.DAO.Impl.ProductDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>Book Store</title>
<%@include file="components/allCss.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	ProductDAOImpl dao = new ProductDAOImpl(DBConnection.getConnection());
	ProductDetails product = dao.getProductById(id);
	%>

	<div class="container">
		<div class="row mt-1 mb-5">
			<div
				class="col-xl-6 col-ld-6 col-md-6 col-sm-12 col-12 text-center mt-3 align-self-center">
				<img width="60%" class="img-fluid"
					src="products/<%=product.getPhoto()%>" alt="book image" />
			</div>
			<div
				class="col-xl-6 col-ld-6 col-md-6 col-sm-12 col-12 mt-3 align-self-center">
				<p>
					<strong style="color: #636e72; font-size: 20px"><%=product.getName()%></strong>
				</p>
				<p><%=product.getDescription()%></p>
				<label> <span class="font-weight-bold">MRP:</span> <%=product.getPrice()%>
					/- Rs

				</label><br />

				
				<div class="text-info mt-3" style="display: flex">
					<div class="text-center mr-3">
						<i class="fas fa-wallet"></i> <br /> Pay on Delivery
					</div>
					<div class="text-center mr-3">
						<i class="fas fa-undo-alt"></i> <br /> 10 Days<br /> Replacement
					</div>
					<div class="text-center mr-3">
						<i class="fas fa-truck"></i> <br /> Fast Delivery
					</div>
					
				</div>
				
				<div class="mt-3 mb-4">
					<button class="btn btn-outline-primary mr-3" onclick="addCart()">
						<i class="fas fa-cart-plus"></i> Add to cart
					</button>
					<button class="btn btn-outline-success" onclick="addCart2()">
						<i class="fa fa-shopping-bag" aria-hidden="true"></i> Buy Now
					</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		$("#searchBook").attr("action", "./newBook.jsp");
		$("#searchBook2").attr("action", "./newBook.jsp");
	</script>
	<script src="js/addCart.js" type="text/javascript"></script>
</body>
</html>
