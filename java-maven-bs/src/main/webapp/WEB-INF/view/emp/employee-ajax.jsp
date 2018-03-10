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
		
		//on click submit via ajax
		$('#save').on('click', function(evt){
			evt.preventDefault();
			var name = $('#name').val();
			var address = $('#address').val();
			var email = $('#email').val();
			var employee = {
					'name' : name,
					'address' : address,
					'email' : email
			};
			$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/ajax-emp/save',
				data : JSON.stringify(employee),
				contentType : 'application/json',
				success : function(){
					alert('save '+ name + ' berhasil');
				}, error : function(){
					alert('save failed');
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="#" method="post">
		<input type="text" id="name" name="name"><br> 
		<input type="text" id="address" name="address"><br> 
		<input type="text" id="email" name="email">
		<br> <input type="submit" id="save" name="save" value="save">
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