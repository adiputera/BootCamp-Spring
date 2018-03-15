<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.css" />
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/parsley.js"></script>
<script>
$(document).ready(function(){
	$('#data-brg').DataTable();
	
});
</script>
<script>
	function isiTable(){
		alert();
		$.ajax({
			url: '${pageContext.request.contextPath}/barang/get-all',
			type: "GET",
			dataType: "json",
			success:function(data) {
					$('#data-brg').DataTable().destroy();
					$('#list-barang').empty();
					$.each(data, function(key, val) {
							$('#list-barang').append('<tr><td>'+ val.namaBarang +'</td><td>'+ val.harga +'</td><td>'
									+ '<select id="jmlstok">'+
									for(int i = 1; i<=val.stock; i++){
										'<option value="'+i+'">'+i+'</select>'
									}
									+'</select>' 
									+'<td><a href="#" key-id="'+val.id+'" class="tbldetail btn btn-success">Pilih</a>' 
							
					});
					$('#data-brg').DataTable({
					      'paging'      : true,
					      'lengthChange': false,
					      'searching'   : true,
					      'ordering'    : true,
					      'info'        : true,
					      'autoWidth'   : false
					    });
			}
		});
	}
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<br/>
	<h2>Data Barang</h2>
	<select id="piluser">
		<c:forEach items="${cust }" var="cs">
			<option value="cs.id">${cs.name }</option>
		</c:forEach>
	</select>
	<table id="data-brg" class="table table-striped table-bordered"
		cellspacing="0" width="100%" onload="isiTable()">
		<thead>
			<th>ID</th>
			<th>Nama Barang</th>
			<th>Harga</th>
			<th>Jumlah</th>
			<th>Action</th>
		</thead>
		<tbody id="list-barang" >
			
		</tbody>
	</table>

</body>
</html>