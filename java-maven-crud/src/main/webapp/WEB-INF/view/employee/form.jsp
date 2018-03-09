<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot-min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/elements.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/coba.css"
	type="text/css">
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
</head>
<body>
	<div id="container">
		<div id="header" class="customFont fontStyle">
			<div id="logo">
				<img
					src="${pageContext.request.contextPath}/resources/img/logo2.png"
					width=115px> <img
					src="${pageContext.request.contextPath}/resources/img/logoacademy.png"
					width=100px> <br> <img
					src="${pageContext.request.contextPath}/resources/img/equine-logo.jpg"
					width=215px>
			</div>
		</div>
		<!--bisa 2 class dipanggil-->
		<!--end header-->
		<div id="menu">
			<ul class="utama">
				<li><a href="/java-maven-crud">Home</a></li>
				<li><a href="#">Employee</a></li>
				<li><a href="#">Mahasiswa</a></li>
				<li><a href="#">Departemen</a></li>
			</ul>
			<div style="clear: both"></div>
		</div>
		<div id="content">
			<div id="isi-content">
				<h1>New/Edit Employee</h1>
				<form:form action="saveEmployee" method="post"
					modelAttribute="employee">
					<table>
						<form:hidden path="id" />
						<tr>
							<td><font color="black">Nama</font></td><td>:</td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td><font color="black">Alamat</font></td><td>:</td>
							<td><form:input path="address" /></td>
						</tr>
						<tr>
							<td><font color="black">Email</font></td><td>:</td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Save" class="btn btn-info"></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<!--end content-->
		<div id="nav"></div>
		<!--end nav-->
		<div style="clear: both"></div>
		<div id="footer">
			<h1>Bootcamp Java Batch 137</h1>
			<hr color="white">
			copyright &copy; Bootcamp 137. All Right Reserved.
		</div>
		<!--end footer-->
</body>
</html>