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
	
	$('#data-room').DataTable();
	
	$('#data-room').on('click', '.tbldelete',function(){
		var id = $(this).attr('id');
		$('#del-id').val(id);
		$('#modal-del').modal('show');
	});
	
	$('#btn-hapus').on('click', function(){
		var id = $('#del-id').val();
		console.log('klik tombol hapus')
		$.ajax({
			url: '${pageContext.request.contextPath}/room/delete/'+id,
			type : 'DELETE',
			success : function(response) {
				$('#modal-del').modal('hide');
				window.location = '${pageContext.request.contextPath}/room';
			}, error : function(){
				alert('gagal');
			}
		});
	}); // end fungsi delete
	
	$('#tbladd').on('click', function(){
		$('#judul-modal').html('Tambah Data Room');
		$('#in-id').val('');
		$('#in-name').val('');
		$('#in-customer').val('');
		$('.in-status').prop('checked', true);
		$('.in-fasilitas').prop('checked', false);
		$('#form-room').modal('show');
	});
	
	
	$('#tblsimpan').on('click', function(){
		var fas = '';
		var index = 0;
		$('.in-fasilitas:checked').each(function(){
			if(index==0){
				fas = $(this).val();
			}
			else{
				fas = fas+', '+$(this).val();
			};
			index++;
		});
		var room = {
				id : $('#in-id').val(),
				name : $('#in-name').val(),
				type : $('#in-type').val(),
				customerName : $('#in-customer').val(),
				fasilitas : fas,
				status : $('input[name=in-status]:checked').val()
			}
			console.log(room);
			validate = $('#add-room').parsley();
			validate.validate();
			if(validate.isValid()){
				$.ajax({
					url : '${pageContext.request.contextPath}/room/save',
					type : 'post',
					data : JSON.stringify(room),
					contentType : 'application/json',
					success : function(data) {
						console.log('data');
						alert('sukses');
						window.location = '${pageContext.request.contextPath}/room';
					},
					error : function() {
						alert('gagal');
					}
				});
			}
	}); // end fungsi simpan
	
	$('#data-room').on('click', '.tblupdate',function(){
		var id = $(this).attr('id');
		console.log('klik edit');
		$.ajax({
				url: '${pageContext.request.contextPath}/room/get-one/'+id,
				type: "GET",
				dataType: "json",
				success:function(data) {	
					console.log('sukses ambil data');
					$('#in-id').val(data.id);
					$('#in-name').val(data.name);
					$('#in-type').val(data.type);
					$('#in-customer').val(data.customerName);
					$('input[name="in-status"][value="'+data.status+'"]').prop('checked', true);
					$('.in-fasilitas').prop('checked', false);
					if(data.fasilitas!=null){
						var fas = data.fasilitas.split(', ');
						var i = 0;
						$.each(fas, function(){
							$('input[name="in-fasilitas"][value="'+fas[i]+'"]').prop('checked', true);
							i++;
						});
						/* for(i=0; i<fas.length;i++){
							$('input[name="in-fasilitas"][value="'+fas[i]+'"]').prop('checked', true);
							console.log(fas[i]);
						} */
					}
					
					$("#form-room").modal("show");
				}
		});
	});
	
	
});
</script>
</head>
<body>
<div class="container">
	<h2>Daftar Room</h2>
	<button class="btn btn-info" id="tbladd">Tambah Data</button>
	<table id="data-room" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>ID</th>
			<th>Room Name</th>
			<th>Room Type</th>
			<th>Customer Name</th>
			<th>Fasilitas</th>
			<th>Status</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${rooms }" var="room">
				<tr>
					<td>${room.id }</td>
					<td>${room.name }</td>
					<td>${room.type }</td>
					<td>${room.customerName }</td>
					<td>${room.fasilitas }</td>
					<td>${room.status }</td>
					<td><a href="#" id="${room.id }"
						class="tbldelete btn btn-warning">Delete</a> | <a href="#"
						id="${room.id }" class="tblupdate btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-room" class="modal" tabindex="-1" role="dialog">
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
					<form id="add-room">
						<input type="hidden" id="in-id">
						<div class="form-group">
							<label for="exampleInputEmail1">Room Name</label> <input type="text"
								class="form-control" id="in-name" placeholder="Nama" data-parsley-required="true" data-parsley-length="[4,30]">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Room Type</label>
							<select id = "in-type">
								<option value="Low">Low</option>
								<option value="Normal">Normal</option>
								<option value="VIP">VIP</option>
								<option value="Deluxe">Deluxe</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Customer Name</label>
							<input type="text" class="form-control" id="in-customer" placeholder="Customer" data-parsley-required="true" data-parsley-length="[4,30]"> 
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Fasilitas : </label><br/>
							<input type="checkbox" class="in-fasilitas" name="in-fasilitas" value="Breakfast"> Breakfast <br/> 
							<input type="checkbox" class="in-fasilitas" name="in-fasilitas" value="Lunch"> Lunch <br/>
							<input type="checkbox" class="in-fasilitas" name="in-fasilitas" value="Dinner"> Dinner <br/>
							<input type="checkbox" class="in-fasilitas" name="in-fasilitas" value="Antar Jemput"> Picked Up <br/>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Status</label>
							<input type="radio" name="in-status" value="Empty" checked> Empty 
							<input type="radio" name="in-status" value="Booked"> Booked
							<input type="radio" name="in-status" value="Filled"> Filled 
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