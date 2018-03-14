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
	$('#data-cus').DataTable();
	
	$('#data-cus').on('click', '.tbldelete',function(){
		var id = $(this).attr('id');
		$('#del-id').val(id);
		$('#modal-del').modal('show');
	});
	
	$('#btn-hapus').on('click', function(){
		var id = $('#del-id').val();
		console.log('klik tombol hapus')
		$.ajax({
			url: '${pageContext.request.contextPath}/customer/delete/'+id,
			type : 'DELETE',
			success : function(response) {
				$('#modal-del').modal('hide');
				window.location = '${pageContext.request.contextPath}/customer';
			}, error : function(){
				
			}
		});
	}); // end fungsi delete
	
	$('#tbladd').on('click', function(){
		$('#judul-modal').html('Tambah Data Customer');
		$('#form-cus').modal('show');
	});
	
	
	$('#tblsimpan').on('click', function(){
		var customer = {
				id : $('#in-id').val(),
				name : $('#in-nama').val(),
				address : $('#in-alamat').val(),
				contact : $('#in-contact').val()
			}
			validate = $('#add-cus').parsley();
			validate.validate();
			if(validate.isValid()){
				$.ajax({
					url : '${pageContext.request.contextPath}/customer/save',
					type : 'post',
					data : JSON.stringify(customer),
					contentType : 'application/json',
					success : function(data) {
						window.location = '${pageContext.request.contextPath}/customer';
					},
					error : function() {
						alert('gagal');
					}
				});
			}
	}); // end fungsi simpan
	
	$('#data-cus').on('click', '.tblupdate',function(){
		var id = $(this).attr('id');
		console.log('klik edit');
		$.ajax({
				url: '${pageContext.request.contextPath}/customer/get-one/'+id,
				type: "GET",
				dataType: "json",
				success:function(data) {	
					console.log('sukses ambil data');
					$('#in-id').val(data.id);
					$('#in-nama').val(data.name);
					$('#in-alamat').val(data.address);
					$('#in-contact').val(data.contact);
					$("#form-cus").modal("show");
				}
		});
	});
	
	
});
</script>
</head>
<body>
<div class="container">
	<br/>
	<h2>Data Customer</h2>
	<button class="btn btn-info" id="tbladd">Tambah Data</button>
	<table id="data-cus" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>ID</th>
			<th>Nama</th>
			<th>Alamat</th>
			<th>Contact</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${custs }" var="cus">
				<tr>
					<td>${cus.id }</td>
					<td>${cus.name }</td>
					<td>${cus.address }</td>
					<td>${cus.contact }</td>
					<td><a href="#" id="${cus.id }"
						class="tbldelete btn btn-warning">Delete</a> | <a href="#"
						id="${cus.id }" class="tblupdate btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-cus" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="add-cus">
						<input type="hidden" id="in-id">
						<div class="form-group">
							<label for="exampleInputEmail1">Nama</label> <input type="text"
								class="form-control" id="in-nama" placeholder="Nama" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Alamat</label>
							<input type="text" class="form-control" id="in-alamat" placeholder="Alamat" data-parsley-required="true" data-parsley-length="[4,30]"> 
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Contact</label>
							<input type="number" class="form-control" id="in-contact" placeholder="Contact" data-parsley-required="true"> 
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="tblsimpan" class="btn btn-primary">Simpan</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Tutup</button>
				</div>
			</div>
		</div>
	</div>

	<div id="modal-del" class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Hapus Data</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Yakin mau hapus data?</p>
					<input type="hidden" id="del-id">
				</div>
				<div class="modal-footer">
					<button type="button" id="btn-hapus" class="btn btn-warning">Hapus!</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>