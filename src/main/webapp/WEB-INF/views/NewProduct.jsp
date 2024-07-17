<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert New Product</title>
</head>
<body>
<h2>Insert New Product</h2>

<form action="saveproduct" method="post" enctype="multipart/form-data">
    Product Name: <input type="text" name="productName"/><br><br>
    Category: <input type="text" name="category"/><br><br> 
    Qty: <input type="text" name="qty"/><br><br>
    Price: <input type="text" name="price"/><br><br>
    MasterImage: <input type="file" name="masterImage"/><br><br>
    <input type="submit" value="Add Product"/>
</form>
</body>
</html>
