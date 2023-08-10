<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>Products</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
			integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
			crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<form action="/ProductServlet" method="post">
	<input type="text" placeholder="search..." name="search">
	<button name="action" value="search">SEARCH</button>
</form>
<a href="<%=request.getContextPath()%>/">Quay Lại</a>
<div class="flex-center">
	<table border="10" cellspacing="10" cellpadding="10">
		<thead>
		<tr>
			<th>STT</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>IMAGE</th>
			<th colspan="3">ACTIONS</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${data}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td><img src="${p.urlImage}" alt=""></td>
				<td><a href="/ProductServlet?action=details&id=${p.id}"><i class="fa-solid fa-eye"></i></a></td>
				<td><a href="/ProductServlet?action=edit&id=${p.id}"><i class="fa-solid fa-gear"></i></a></td>
				<td><a href="/ProductServlet?action=delete&id=${p.id}"><i class="fa-solid fa-trash"></i></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>
