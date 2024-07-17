<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.eProductBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
	integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap')
	;

body {
	font-family: "Poppins", sans-serif;
	color: #444444;
	background: linear-gradient(135deg, #f8f9fa, #e9ecef);
	overflow-x: hidden; /* Prevent horizontal scrollbar */
}

a, a:hover {
	text-decoration: none;
	color: inherit;
}

.section-products {
	padding: 80px 0 54px;
}

.section-products .header {
	margin-bottom: 30px;
}

.section-products .header h3 {
	font-size: 1.5rem;
	color: #fe302f;
	font-weight: 500;
}

.section-products .header h2 {
	font-size: 2.5rem;
	font-weight: 400;
	color: #333333;
}

.section-products .single-product {
	margin-bottom: 30px;
	border: 1px solid #e1e1e1;
	border-radius: 10px;
	overflow: hidden;
	background: #ffffff;
	box-shadow: 0 4px 8px rgba(0,0,0,0.1);
	transition: transform 0.3s, box-shadow 0.3s;
}

.section-products .single-product:hover {
	transform: translateY(-10px);
	box-shadow: 0 8px 16px rgba(0,0,0,0.2);
}

.section-products .single-product .part-1 {
	position: relative;
	height: 260px;
	max-height: 260px;
	margin-bottom: 20px;
	overflow: hidden;
}
.section-products .single-product .part-1::before {
	position: absolute;
	content: "";
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
	transition: all 0.3s;
}
.section-products .single-product:hover .part-1::before {
	transform: scale(1.2, 1.2) rotate(5deg);
}
.section-products .single-product .part-1 img {
	width: 100%;
	height: 100%;
	object-fit: contain
	transition: transform 0.3s;
}

.section-products .single-product:hover .part-1 img {
	transform: scale(1.1);
}

.section-products .single-product .part-1 ul {
	position: absolute;
	top: 5px;
	right: 10px;
	margin: 0;
	padding: 0;
	list-style: none;
	opacity: 0;
	transition: opacity 0.5s;
}

.section-products .single-product:hover .part-1 ul {
	opacity: 1;
}

.section-products .single-product .part-1 ul li {
	display: inline-block;
	margin-right: 3px;
}

.section-products .single-product .part-1 ul li a {
	display: inline-block;
	width: 40px;
	height: 40px;
	line-height: 40px;
	background-color: rgba(255,255,255,0.8);
	color: #444444;
	text-align: center;
	border-radius: 50%;
	box-shadow: 0 2px 20px rgb(50 50 50 / 10%);
	transition: background-color 0.3s, color 0.3s;
}

.section-products .single-product .part-1 ul li a:hover {
	background-color: #fe302f;
	color: #ffffff;
}

.section-products .single-product .part-2 {
	padding: 10px;
	text-align: center;
}

.section-products .single-product .part-2 .product-title {
	font-size: 1.1rem;
	font-weight: 600;
	margin-bottom: 5px;
	color: #333333;
}

.section-products .single-product .part-2 h4 {
	display: inline-block;
	font-size: 1.1rem;
	margin-bottom: 5px;
	color: #fe302f;
}

.section-products .single-product .part-2 .product-old-price {
	position: relative;
	font-size: 0.9rem;
	color: #999999;
	margin-right: 10px;
	text-decoration: line-through;
}
</style>

</head>
<body>

	<%
	List<eProductBean> products = (List<eProductBean>) request.getAttribute("products");
	%>

	<div class="row mt-2 mb-2">
		<div class="col-md text-left">
			<a href="logout" class="btn btn-success">Logout</a>
		</div>
	</div>

	<section class="section-products">
		<div class="container">
			<div class="row justify-content-center text-center">
				<div class="col-md-8 col-lg-6">
					<div class="header">
						<h3>Featured Product</h3>
						<h2>Popular Products</h2>
					</div>
				</div>
			</div>
			<div class="row">

				<!-- start -->
				<%
				for (eProductBean p : products) {
				%>
				<!-- Single Product -->
				<div class="col-md-6 col-lg-4 col-xl-3">
					<div class="single-product">
						<div class="part-1">
							<a href="userviewimage?productId=<%=p.getProductId()%>"> <img
								src="<%=p.getProductImagePath()%>" />
							</a>
							<ul>
								<li><a href="addtocart?productId=<%=p.getProductId()%>"><i
										class="fas fa-shopping-cart"></i></a></li>
								<li><a href="#"><i class="fas fa-heart"></i></a></li>
								<li><a href="#"><i class="fas fa-eye"></i></a></li>
							</ul>
						</div>
						<div class="part-2">
							<h3 class="product-title"><%=p.getProductName()%></h3>
							<h4 class="product-old-price"><%=p.getPrice() * 1.05%></h4>
							<h4 class="product-price"><%=p.getPrice()%></h4>
						</div>
					</div>
				</div>
				<!-- end -->
				<%
				}
				%>
			</div>
		</div>
	</section>
</body>
</html>
