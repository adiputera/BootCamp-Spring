<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	jQuery(document).ready(function(){
		$('.delete').on('click', function(){
			var id = $(this).attr('id');
			var conf = confirm("yakin nih?");
			if(conf == true){
				window.location="${pageContext.request.contextPath}/employee/delete/"+id;
			}
				return false;
		});
	});
</script>
</head>
<body>
	<form action="${pageContext.request.contextPath}/employee/save"
		method="post">
		<input type="text" name="name"><br> <input type="text"
			name="address"><br> <input type="text" name="email">
		<nr> <input type="submit" name="save" value="save">
	</form>
	<table>
		<thead>
			<th>Name</th>
			<th>alamat</th>
			<th>Email</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${employees }" var="emp">
				<tr>
					<td>${emp.name }</td>
					<td>${emp.address }</td>
					<td>${emp.email }</td>
					<td>
						<a href="#" id="${emp.id }" class="delete">Delete</a> 
						| 
						<a href="${pageContext.request.contextPath }/employee/edit/${emp.id}" id="${emp.id }" class="update">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>