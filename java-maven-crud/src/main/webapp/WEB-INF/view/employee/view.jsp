<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-grid.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-reboot-min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/elements.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/coba.css" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/myjs.js"></script>
</head>
<body>
	<div id="container">
		<div id="header" class="customFont fontStyle">
			<div id="logo">
				<img src="${pageContext.request.contextPath}/resources/img/logo2.png" width=115px> <img
					src="${pageContext.request.contextPath}/resources/img/logoacademy.png" width=100px> <br> <img
					src="${pageContext.request.contextPath}/resources/img/equine-logo.jpg" width=215px>
			</div>
		</div>
		<!--bisa 2 class dipanggil-->
		<!--end header-->
		<div id="menu">
			<ul class="utama">
				<li><a href="#">Home</a></li>
				<li><a href="#">Employee</a></li>
				<li><a href="#">Mahasiswa</a></li>
				<li><a href="#">Departemen</a></li>
			</ul>
			<div style="clear: both"></div>
		</div>
		<div id="content">
			<div id="isi-content">
				<h2>Daftar Tabel Employee</h2>

				<table border="1" width=100%>
					<th>ID</th>
					<th>Nama</th>
					<th>Alamat</th>
					<th>Email</th>
					<th>Action</th>
					<c:forEach var="employee" items="${listEmployee}">
						<tr>
							<td>${employee.id}</td>
							<td>${employee.name}</td>
							<td>${employee.address}</td>
							<td>${employee.email}</td>
							<td><a href="editEmployee?id=${employee.id}" class="btn btn-info">Edit</a> <a
								href="deleteEmployee?id=${employee.id}" class="btn btn-danger">Delete</a></td>

						</tr>
					</c:forEach>
				</table>
				<a href="newEmployee" class="btn btn-info btn-lg">Tambah
					Employee</a>
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
	</div>
	<!--end container-->
</body>
</html>