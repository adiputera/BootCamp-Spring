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
	$('#tabel-barang').DataTable({
	      'paging'      : true,
	      'lengthChange': true,
	      'searching'   : false,
	      'ordering'    : true,
	      'info'        : true,
	      'autoWidth'   : false
	    })
	    
	 $('#btn-search').on('click', function(){
		 var word = $('#search').val();
		 windows.location="${pageContext.request.contextPath}/menu/src?search="+word;
	 });
});
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<br/>
	<div id="search-box">
		<span>search</span>
		<span><input type="text" id="search"></span>
		<span><a href="#" id="btn-search" class = "btn btn-primary">Search</a></span>
	</div>
	<div id="daftar-barang">
		<table class="table table-striped table-bordered" cellspacing="0" width="100%" id="tabel-barang">
			<thead>
				<th>Nama Barang</th>
				<th>harga</th>
				<th>Jumlah</th>
				<th>Beli</th>
			</thead>
			<tbody>
				<c:forEach items = "${barangs }" var="brg">
					<tr>
						<td>${brg.namaBarang }</td>
						<td>Rp. ${brg.harga } </td>
						<td>
							<select class="piljml">
								<% int jml = 0; %>
								<c:forEach begin="1" end="${brg.stock }">
									<option value="<%=jml = ++jml %>"><%=jml %></option>
								</c:forEach>
							</select>
						</td>
						<td><a href="#" class="btn btn-info">Pilih</a></td>
					</tr>
				</c:forEach>
			</tbody>
		
		
		</table>
	</div>

</body>
</html>