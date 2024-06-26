<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Product By Name</title>
</head>
<body>
    <h2>Delete Product By Name</h2>
    
    <form action="deleteProductByName" method="post">
        Enter the Name of the Product: <input type="text" name="productName"/><br><br>
        <input type="submit" value="Delete Product"/>
    </form>
</body>
</html>
