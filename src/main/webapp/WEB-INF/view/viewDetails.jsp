<%@ page import="com.example.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: binh1
  Date: 8/8/2023
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Details</title>
</head>
<body>
<%--<%--%>
<%--	List<Product> list = (List<Product>) session.getAttribute("data");--%>
<%--	for (Product p: list) {--%>
<%--		System.out.println(p.getName());--%>
<%--	}--%>
<%--%>--%>
<p><%=session.getAttribute("detail").toString()%></p>
<h1>${sessionScope.detail.name}</h1>
<h2>${sessionScope.detail.description}</h2>
<h3>${sessionScope.detail.price}</h3>
<img src="${sessionScope.detail.urlImage}" alt="" width="300" height="300" style="object-fit: cover">
</body>
</html>
