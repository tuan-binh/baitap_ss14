<%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 8/7/2023
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add Product</title>
</head>
<body>
<form action="/ProductServlet" method="post">
	<label for="name">Name: </label> <br>
	<input type="text" id="name" name="name"> <br>
	<label for="desc">Description: </label> <br>
	<textarea name="desc" id="desc" cols="30" rows="10"></textarea> <br>
	<label for="price">Price</label> <br>
	<input type="text" id="price" name="price"> <br>
	<label for="url">Image: </label> <br>
	<input type="text" name="urlImage" id="url">
	<button name="action" value="add">ADD</button>
</form>
</body>
</html>
