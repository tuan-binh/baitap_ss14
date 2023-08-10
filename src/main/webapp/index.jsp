<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>JSP - Hello World</title>
	<link rel="stylesheet" href="./index.css">
</head>
<body>
<form action="/ProductServlet" method="get" class="flex">
	<h1>Manager Product</h1>
	<button name="action" value="getList" class="btn">SHOW PRODUCT</button>
	<br>
	<button name="action" value="addProduct" class="btn">ADD PRODUCT</button>
</form>
</body>
</html>