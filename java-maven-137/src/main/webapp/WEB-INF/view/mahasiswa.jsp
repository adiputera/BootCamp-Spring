<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
	jQuery(document).ready(function() {
		$('#data-emp').DataTable();
		
		$('.update').on('click', function(){
			var id = $(this).attr('id');
			$.ajax({
				url : '${pageContext.request.contextPath}/mhs/get-one/'+id,
				type : 'get',
				success : function(mhs){
					setEditMhs(mhs);
					$('#form-mhs').modal();
				}, error : function(){
					alert('gagal');
				},
				dataType : 'json'
			});
		}); // end .update
		
		$('#tbladd').on('click', function(){
			//var id = $(this).attr('id');
			$('#form-mhs').modal();
		}); // end .update
		
		function setEditMhs(mhs){
			console.log(mhs);
			$('#in-id').val(mhs.id);
			$('#in-name').val(mhs.name);
			$('#piljur').val(mhs.jurusan.id);
		}
		
		$('#btn-update').click(function(){
			var mhs = {
					id : $('#in-id').val(),
					name : $('#in-name').val(),
					jurusan : {
						id : $('#piljur').val()
					}
			}
			console.log(mhs);
			$.ajax({
				url : '${pageContext.request.contextPath}/mhs/update',
				type : 'put',
				data : JSON.stringify(mhs),
				contentType : 'application/json',
				success : function(data){
					window.location = '${pageContext.request.contextPath}/mhs';
				}, error : function(){
					alert('gagal');
				}
			});
		});
		
	}); // end document ready
</script>
</head>
<body>
<div class="container">
	<div id="save-form">
		<form:form action="${pageContext.request.contextPath }/mhs/save" method="post" commandName="mahasiswa">
			<form:errors path="*" cssClass="errorblock" element="div"/>
			<div class="form-group">
				<label>Nama </label>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label>Jurusan </label>
				<form:select path = "jurusan.id" class="form-control">
					<c:forEach items="${jurs }" var="jur">
						<option value="${jur.id }"> ${jur.namaJurusan } </option>
					</c:forEach>
				</form:select>
			</div>
			<form:button class="btn btn-info">Simpan</form:button>
		</form:form>
	</div>
</div>
	<button class="btn btn-info" id="tbladd">Tambah Data</button>
	<table id="data-emp" class="table table-striped table-bordered"
		cellspacing="0" width="100%">
		<thead>
			<th>Name</th>
			<th>Jurusan</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${mhss }" var="emp">
				<tr>
					<td>${emp.name }</td>
					<td>${emp.jurusan.namaJurusan }</td>
					<td><a href="#" id="${emp.id }" class="tbldelete btn btn-warning">Delete</a>
						| <a href="#" id="${emp.id }" class="update btn btn-success">Update</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="form-mhs" class="modal" tabindex="-1" role="dialog">
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
							<label for="exampleInputPassword1">Jurusan</label>
							<select id="piljur" class="custom-select custom-select-md">
								<c:forEach items="${jurs }" var="jur">
									<option value="${jur.id }"> ${jur.namaJurusan } </option>
								</c:forEach>
							</select>
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