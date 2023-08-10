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
	<title>Edit Product</title>
</head>
<body>
<form action="/ProductServlet" method="post">
	<input type="text" value="${data.id}" readonly name="id">
	<label for="name">Name: </label> <br>
	<input value="${data.name}" type="text" id="name" name="name"> <br>
	<label for="desc">Description: </label> <br>
	<textarea value="${data.description}" name="desc" id="desc" cols="30" rows="10"></textarea> <br>
	<label for="price">Price</label> <br>
	<input value="${data.price}" type="text" id="price" name="price"> <br>
	<label for="url">Image: </label> <br>
	<input value="${data.urlImage}" type="text" name="urlImage" id="url">
	<button name="action" value="update">ADD</button>
</form>
</body>
</html>
