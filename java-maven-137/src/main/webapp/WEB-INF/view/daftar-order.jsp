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
	 }); // end fungsi table
	    
	 $('#go-bayar').on('click', function(){
		var barangs = [];
		var detailPenjualan = [];
		
		$('#tabel-barang > tbody > tr').each(function(index, data){
			
			var dp = {
					barang : {
						id : $(data).attr('id')
					},
					jumlahBeli : $(data).find('td').eq(2).text()
			}
			detailPenjualan.push(dp);
		});
		
		var penjualan = {
				customer : {
					id : "${customer.id}"
				},
				detailPenjualan : detailPenjualan,
				totalHarga : "${totalHarga}",
				totalItem : "${totalItem}"
		};
		console.log(penjualan);
		
		$.ajax({
			url : '${pageContext.request.contextPath}/penjualan/save',
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(penjualan),
			success : function(data){
				alert('sukses');
				console.log(data);
				window.location = '${pageContext.request.contextPath}/menu';
			},
			error : function(){
				alert('error');
			}
		});
	 }); // end fungsi bayar
	 
	 $('#tabel-barang').on('click', '.btn-cancel', function(){
		var id = $(this).attr('id');
	 	$.ajax({
	 		url : '${pageContext.request.contextPath}/order/cancel?id='+id,
	 		type : 'get',
	 		success : function(data){
	 			alert('sukses batal order');
	 			location.reload();
	 		},
	 		error : function(){
	 			alert('gagal');
	 		}
	 	});
	 });
});
</script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<br/>
	<a href="${pageContext.request.contextPath }/barang" class="btn btn-info">CRUD Barang</a>
	<a href="${pageContext.request.contextPath }/customer" class="btn btn-info">CRUD Customer</a>
	<a href="${pageContext.request.contextPath }/menu" class="btn btn-info">Pesan Barang</a>
	<br/>
	<div id="info-pembelian" style="padding : 20px 0 20px 0" >
		<table id="info-pembelian">
			<tr>
				<th>
					Name
				</th>
				<td>
					: 
				</td>
				<td>
					${customer.name }
				</td>
			</tr>
			<tr>
				<th>
					Email
				</th>
				<td>
					:
				</td>
				<td>
					${customer.email }
				</td>
			</tr>
			<tr>
				<th>
					Total Item
				</th>
				<td>
					:
				</td>
				<td>
					${totalItem }
				</td>
			</tr>
			<tr>
				<th>
					Total Bayar
				</th>
				<td>
					: 
				</td>
				<td>
					${totalHarga }
				</td>
			</tr>
		</table>
	</div>
	<div id="daftar-order">
		<table class="table table-striped table-bordered" cellspacing="0" width="100%" id="tabel-barang">
			<thead>
				<th>Nama Barang</th>
				<th>harga</th>
				<th>Jumlah</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach items = "${orders }" var="order">
					<tr id="${order.barang.id }">
						<td>${order.barang.namaBarang }</td>
						<td>Rp. ${order.barang.harga } </td>
						<td>${order.jumlahBeli }</td>
						<td><a href="#" id="${order.id }" class="btn-cancel btn btn-info">Cancel</a></td>
					</tr>
				</c:forEach>
			</tbody>
		
		
		</table>
		
		<a href="#" id="go-bayar" class="btn btn-primary btn-md">Bayar</a>
		
	</div>

</body>
</html>