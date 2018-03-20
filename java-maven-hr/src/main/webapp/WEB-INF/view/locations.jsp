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
	
	$('#data-locations').DataTable();
	
	$('#data-locations').on('click', '.tbldelete',function(){
		var id = $(this).attr('id');
		$('#del-id').val(id);
		$('#modal-del').modal('show');
	});
	
	$('#btn-hapus').on('click', function(){
		var id = $('#del-id').val();
		console.log('klik tombol hapus')
		$.ajax({
			url: '${pageContext.request.contextPath}/locations/delete/'+id,
			type : 'DELETE',
			success : function(response) {
				$('#modal-del').modal('hide');
				window.location = '${pageContext.request.contextPath}/locations';
			}, error : function(){
				alert('gagal');
			}
		});
	}); // end fungsi delete
	
	$('#tbladd').on('click', function(){
		$('#judul-modal').html('Tambah Data Room');
		$('#in-id').val('');
		$('#in-street').val('');
		$('#in-postal').val('');
		$('#in-province').val('');
		$('#in-city').val('');
		$('#form-locations').modal('show');
	});
	
	
	$('#tblsimpan').on('click', function(){
		var locations = {
				id : $('#in-id').val(),
				streetAddress : $('#in-street').val(),
				city : $('#in-city').val(),
				province : $('#in-province').val(),
				postalCode : $('#in-postal').val(),
				countries : {
					id : $('#in-countries').val()
				}
			}
			console.log(locations);
			validate = $('#add-locations').parsley();
			validate.validate();
			if(validate.isValid()){
				$.ajax({
					url : '${pageContext.request.contextPath}/locations/save',
					type : 'post',
					data : JSON.stringify(locations),
					contentType : 'application/json',
					success : function(data) {
						console.log('data');
						window.location = '${pageContext.request.contextPath}/locations';
					},
					error : function() {
						alert('gagal');
					}
				});
			}
	}); // end fungsi simpan
	
	$('#data-locations').on('click', '.tblupdate',function(){
		var id = $(this).attr('id');
		console.log('klik edit');
		$.ajax({
				url: '${pageContext.request.contextPath}/locations/get-one/'+id,
				type: "GET",
				dataType: "json",
				success:function(data) {	
					console.log('sukses ambil data');
					$('#in-id').val(data.id);
					$('#in-street').val(data.streetAddress);
					$('#in-postal').val(data.postalCode);
					$('#in-province').val(data.province);
					$('#in-city').val(data.city);
					$('#in-countries').val(data.countries.id);
					$("#form-locations").modal("show");
				}
		});
	});
	
	
});
</script>
</head>
<body>
<div class="container">
	<br/>
	<a href="${pageContext.request.contextPath }/" class="btn btn-success">Halaman Depan</a>
	<a href="${pageContext.request.contextPath }/regions" class="btn btn-success">Regions</a>
	<a href="${pageContext.request.contextPath }/countries" class="btn btn-success">Countries</a>
	<a href="${pageContext.request.contextPath }/locations" class="btn btn-success">Locations</a>
	<a href="${pageContext.request.contextPath }/departments" class="btn btn-success">Departments</a>
	<a href="${pageContext.request.contextPath }/employees" class="btn btn-success">Employees</a>
	<br/>
	<h2>Daftar Locations</h2>
	<button class="btn btn-info" id="tbladd">Tambah Data</button>
	<table id="data-locations" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>ID</th>
			<th>Street Address</th>
			<th>City</th>
			<th>Province</th>
			<th>Postal Code</th>
			<th>Country</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${locationss }" var="locations">
				<tr>
					<td>${locations.id }</td>
					<td>${locations.streetAddress }</td>
					<td>${locations.city }</td>
					<td>${locations.province }</td>
					<td>${locations.postalCode }</td>
					<td>${locations.countries.countriesName }</td>
					<td><a href="#" id="${locations.id }"
						class="tbldelete btn btn-warning">Delete</a> | <a href="#"
						id="${locations.id }" class="tblupdate btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-locations" class="modal" tabindex="-1" role="dialog">
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
					<form id="add-locations">
						<input type="hidden" id="in-id">
						<div class="form-group">
							<label for="exampleInputEmail1">Street Address</label> <input type="text"
								class="form-control" id="in-street" placeholder="Street Address" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">City</label>
							<input type="text"
								class="form-control" id="in-city" placeholder="City" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Province</label>
							<input type="text" class="form-control" id="in-province" placeholder="Province" data-parsley-required="true" data-parsley-length="[4,30]"> 
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Postal Code : </label><br/>
							<input type="text" class="form-control" id="in-postal" placeholder="Postal Code" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Countries :</label>
							<select id="in-countries">
								<c:forEach items="${countriess }" var="cou">
									<option value="${cou.id }">${cou.countriesName }</option>
								</c:forEach>
							</select>
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