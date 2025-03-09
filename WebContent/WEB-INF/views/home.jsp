<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Retail App</title>
<!-- Bootstrap 4 CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- FontAwesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
.myCard {
	transition: transform 0.3s ease-in-out;
}

.myCard:hover {
	transform: scale(1.05);
}

.padding-bottom10 {
	padding-bottom: 10px;
}
</style>
</head>
<body>

	<%@ include file="header.jsp"%>

	<!-- Product Section -->
	<div class="container mt-4">
		<h2 class="text-center mb-4">Our Products</h2>
		<div class="row">
			<c:forEach var="product" items="${products}">
				<div class="col-md-4 col-sm-6 padding-bottom10">
					<div class="card shadow rounded myCard">
						<div class="card-body">
							<h4 class="card-title">${product.name }</h4>
							<img src="<c:url value='/images/watch.jpg' />" alt="Image">
							
							<p class="card-text text-muted">${product.description }</p>
							<p class="card-text">
								<b>Price:</b> $${product.price } <br> <b>Category:</b>
								${product.category }
							</p>
							<a href="/SpringDemo/cart?productId=${product.id}"
								class="btn btn-primary btn-block">Add to Cart <i
								class="fas fa-cart-plus"></i></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Footer -->
	<footer class="bg-dark text-white text-center py-3 mt-4">
		<p>&copy; 2025 My Retail App. All rights reserved.</p>
	</footer>

	<!-- Bootstrap 4 JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
