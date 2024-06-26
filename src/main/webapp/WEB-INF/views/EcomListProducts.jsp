<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.eProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Products List</h2>
	
	<%
		List<eProductBean> products = (List<eProductBean>) request.getAttribute("products");
	%>
	<table border="1">
		<tr>
			<td>ProductId</td>
			<td>ProductName</td>
			<td>Action</td>
		</tr>
		<%
			for (eProductBean p : products)
			{
				out.print("<tr>");
				out.print("<td>"+p.getProductId()+"</td><td>"+p.getProductName()+"</td><td> <a href='deleteProduct?ProductId="+p.getProductId()+"'>DELETE</a> ");
				out.print("</tr>");
			}
		%>
		
	</table>
	
</body>
</html>