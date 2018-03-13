<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script
	src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
	
<script>
	jQuery(document).ready(function(){
						$('.delete').on('click',function() {
							var id = $(this).attr('id');
							var conf = confirm("yakin nih?");
							if (conf == true) {
								window.location = "${pageContext.request.contextPath}/employee/delete/"
										+ id;
							}
							return false;
						}); //end fungsi delete

						//on click submit via ajax
						$('#save')
								.on(
										'click',
										function(evt) {
											evt.preventDefault();
											var name = $('#name').val();
											var address = $('#address').val();
											var email = $('#email').val();
											var employee = {
												'name' : name,
												'address' : address,
												'email' : email
											};
											$
													.ajax({
														type : 'post',
														url : '${pageContext.request.contextPath}/ajax-emp/save',
														data : JSON
																.stringify(employee),
														contentType : 'application/json',
														success : function() {
															alert('save '
																	+ name
																	+ ' berhasil');
														},
														error : function() {
															alert('save failed');
														}
													});
										}); // end fungsi save

						// data tables
						$('#data-emp').DataTable();
						
						$('.update').on('click', function(evt){
							evt.preventDefault();
							var id = $(this).attr('id');
							
							$.ajax({
								url : '${pageContext.request.contextPath}/ajax-emp/get-one/'+id,
								type : 'GET',
								success : function(emp){
									$('#in-name').val(emp.name);
									$('#in-address').val(emp.address);
									$('#in-email').val(emp.email);
									$('#in-id').val(emp.id);
									console.log(emp);
									$('#form-emp').modal();
									
								},
								error : function(){
									alert('failed getting data');
								},
								dataType: 'json'
							});
						}); // end fungsi ambil data ke form
						
						$('#btn-update').on('click', function(){
							var employee = {
									id : $('#in-id').val(),
									name : $('#in-name').val(),
									address : $('#in-address').val(),
									email : $('#in-email').val(),
							}
							console.log(employee);
							$.ajax({
								url : '${pageContext.request.contextPath}/ajax-emp/update',
								type : 'put',
								data : JSON.stringify(employee),
								contentType : 'application/json',
								success : function(data){
									window.location='${pageContext.request.contextPath}/ajax-emp'
								}, error : function(){
									alert('gagal');
								}
							});
						}); // end fungsi update
						
						$('.tbldelete').on('click', function(){
							var id = $(this).attr('id');
							$('#del-id').val(id); //del-id hidden input di modal konfirmasi delete
							$('#modal-del').modal();
						});
						
						$('#btn-hapus').on('click', function(){
							var id = $('#del-id').val();
							$.ajax({
								url : '${pageContext.request.contextPath}/ajax-emp/delete/'+id,
								type : 'delete',
								success : function(data){
									window.location='${pageContext.request.contextPath}/ajax-emp'
								}, error : function(){
									alert('gagal');
								}
							});
						});
					});
</script>
</head>
<body>
	<form action="#" method="post">
		<input type="text" id="name" name="name"><br> <input
			type="text" id="address" name="address"><br> <input
			type="text" id="email" name="email"> <br> <input
			type="submit" id="save" name="save" value="save">
	</form>
	<table id="data-emp" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>Name</th>
			<th>alamat</th>
			<th>Email</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.name }</td>
					<td>${emp.address }</td>
					<td>${emp.email }</td>
					<td><a href="#" id="${emp.id }" class="tbldelete btn btn-warning">Delete</a>
						| <a href="#" id="${emp.id }" class="update btn btn-success">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-emp" class="modal" tabindex="-1" role="dialog">
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
					<form>
						<input type="hidden" id="in-id">
						<div class="form-group">
							<label for="exampleInputEmail1">Nama</label> <input type="text"
								class="form-control" id="in-name" placeholder="Nama">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Alamat</label> <input
								type="text" class="form-control" id="in-address"
								placeholder="Password">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Email</label> <input
								type="email" class="form-control" id="in-email"
								aria-describedby="emailHelp" placeholder="Enter email">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" id="btn-update" class="btn btn-primary">Simpan</button>
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
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Yakin mau hapus data?</p>
        <input type="hidden" id="del-id">
      </div>
      <div class="modal-footer">
        <button type="button" id="btn-hapus" class="btn btn-warning">Hapus!</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>