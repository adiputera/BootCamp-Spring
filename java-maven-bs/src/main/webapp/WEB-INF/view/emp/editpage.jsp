<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/employee/save"
		method="post">
		<intput type="hidden" name="id" value="${employee.id }">
		<input type="text" name="name" value="${employee.name }"><br> 
		<input type="text" name="address" value="${employee.address }"><br> 
		<input type="text" name="email" value="${employee.email }">
		<br> <input type="submit" name="save" value="save">
	</form>
</body>
</html>