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
	
	$('#data-employees').DataTable();
	
	$('#data-employees').on('click', '.tbldelete',function(){
		var id = $(this).attr('id');
		$('#del-id').val(id);
		$('#modal-del').modal('show');
	});
	
	$('#btn-hapus').on('click', function(){
		var id = $('#del-id').val();
		console.log('klik tombol hapus')
		$.ajax({
			url: '${pageContext.request.contextPath}/employees/delete/'+id,
			type : 'DELETE',
			success : function(response) {
				$('#modal-del').modal('hide');
				window.location = '${pageContext.request.contextPath}/employees';
			}, error : function(){
				alert('gagal');
			}
		});
	}); // end fungsi delete
	
	$('#tbladd').on('click', function(){
		$('#judul-modal').html('Tambah Data Room');
		$('#in-id').val('');
		$('#in-fisrtname').val('');
		$('#in-lastname').val('');
		$('#in-email').val('');
		$('#in-phone').val('');
		$('#in-hire').val('');
		$('#in-salary').val('');
		$('#in-commission').val('');
		$('#form-employees').modal('show');
	});
	
	
	$('#tblsimpan').on('click', function(){
		var employees = {
				id : $('#in-id').val(),
				firstName : $('#in-firstname').val(),
				lastName : $('#in-lastname').val(),
				email : $('#in-email').val(),
				phoneNumber : $('#in-phone').val(),
				hireDate : $('#in-hire').val(),
				salary : $('#in-salary').val(),
				commissionPct : $('#in-commission').val(),
				manager : {
					id : $('#in-manager').val()
				},
				departments : {
					id : $('#in-department').val()
				}
				
			}
			console.log(employees);
			validate = $('#add-employees').parsley();
			validate.validate();
			if(validate.isValid()){
				$.ajax({
					url : '${pageContext.request.contextPath}/employees/save',
					type : 'post',
					data : JSON.stringify(employees),
					contentType : 'application/json',
					success : function(data) {
						console.log('data');
						alert('sukses');
						window.location = '${pageContext.request.contextPath}/employees';
					},
					error : function() {
						alert('gagal');
					}
				});
			}
	}); // end fungsi simpan
	
	$('#data-employees').on('click', '.tblupdate',function(){
		var id = $(this).attr('id');
		console.log('klik edit');
		$.ajax({
				url: '${pageContext.request.contextPath}/employees/get-one/'+id,
				type: "GET",
				dataType: "json",
				success:function(data) {	
					console.log('sukses ambil data');
					$('#in-id').val(data.id);
					$('#in-fisrtname').val(data.firstName);
					$('#in-lastname').val(data.lastName);
					$('#in-email').val(data.email);
					$('#in-phone').val(data.phoneNumber);
					$('#in-hire').val(data.hireDate);
					$('#in-salary').val(data.salary);
					$('#in-commission').val(data.commissionPct);
					$("#form-employees").modal("show");
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
	<h2>Daftar Employee</h2>
	<button class="btn btn-info" id="tbladd">Tambah Data</button>
	<table id="data-employees" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Hire Date</th>
			<th>Salary</th>
			<th>Commission</th>
			<th>Manager</th>
			<th>Department</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${employeess }" var="employees">
				<tr>
					<td>${employees.id }</td>
					<td>${employees.firstName }</td>
					<td>${employees.lastName }</td>
					<td>${employees.email }</td>
					<td>${employees.phoneNumber }</td>
					<td>${employees.hireDate }</td>
					<td>${employees.salary }</td>
					<td>${employees.commissionPct }</td>
					<td>${employees.manager.firstName } ${employees.manager.lastName }</td>
					<td>${employees.departments.departmentName }</td>
					<td><a href="#" id="${employees.id }"
						class="tbldelete btn btn-warning">Delete</a> | <a href="#"
						id="${employees.id }" class="tblupdate btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-employees" class="modal" tabindex="-1" role="dialog">
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
					<form id="add-employees">
						<input type="hidden" id="in-id">
						<div class="form-group">
							<label for="exampleInputEmail1">First Name</label> <input type="text"
								class="form-control" id="in-firstname" placeholder="Nama" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Last Name</label> <input type="text"
								class="form-control" id="in-lastname" placeholder="Nama" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input type="email"
								class="form-control" id="in-email" placeholder="email@email.email" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Phone Number</label> <input type="text"
								class="form-control" id="in-phone" placeholder="080989999" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Hire Date</label> <input type="date"
								class="form-control" id="in-hire" data-parsley-required="true"">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Salary</label> <input type="number"
								class="form-control" id="in-salary" placeholder="10000" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Commission PCT</label> <input type="number"
								class="form-control" id="in-commission" placeholder="10000" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Manager :</label>
							<select id="in-manager">
								<c:forEach items="${employeess }" var="emp">
									<option value="${emp.id }">${emp.firstName } ${emp.lastName }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Department :</label>
							<select id="in-department">
								<c:forEach items="${deps }" var="dep">
									<option value="${dep.id }">${dep.departmentName }</option>
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