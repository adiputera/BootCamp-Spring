<%@ include file="/WEB-INF/view/MasterPage/layout.jsp"%>
<section class="content">
	<h2>Data Departemen</h2>
	<button type="button" class="tbladd btn btn-info btn-lg">Tambah Departemen</button>
	<table  id="data-dep" class="table table-striped table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Nama Departemen</th>
			<th>Alamat</th>
			<th>Email</th>
			<th>Action</th>
		</thead>
		<tbody id="isi-dep">
			<c:forEach items="${deps }" var="dep">
				<tr>
					<td>${dep.id }</td>
					<td>${dep.namaDepartemen }</td>
					<td>${dep.alamat }</td>
					<td>${dep.email }</td>
					<td>
						<a href="#" key-id="${dep.id }" class="tbldetail btn btn-success">Detail</a>
						|
						<a href="#" key-id="${dep.id }" class="tblupdate btn btn-info">Update</a>
						|
						<a href="#konfirmdel" data-toggle="modal" key-id="${dep.id }" class="delete btn btn-danger">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> <!-- end table -->
	
	<!-- begin form save -->
	<div class="modal fade" id="frminsert" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close modalcancel" data-dismiss="modal">&times;</button>
					<h4 id="judul-modal">Tambahkan Departemen</h4>
				</div>
				<div class="modal-body">
					<form data-parsley-validate method="post">
						<table>
							<tr>
								<td>Nama Departemen</td>
								<td>:</td>
								<td><input type="text" name="namaDepartemen" id="namaDepartemen" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td>Alamat</td>
								<td>:</td>
								<td><input type="text" name="alamat" id="alamat" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td>Email</td>
								<td>:</td>
								<td><input type="email" name="email" id="email" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td colspan="2"><button type="button" class="btn btn-primary" id="tblsimpan">Simpan</button></td>
								<td><input type="hidden" name="id" id="id"></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- end form save -->
	
	<!-- begin konfirmasi delete -->
	<div id="konfirmdel" class="modal fade" role="dialog">
		<div class="modal-dialog modal-confirm">
			<div class="modal-content">
				<div class="modal-header">			
					<h4 class="modal-title">Hapus Data?</h4>	
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Apakah Anda Yakin Ingin Menghapus Data Ini?</p>
					<input type="hidden" id="hapus-id">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal" id="batal-insert">Batal</button>
					<button type="button" class="btn btn-danger" id="tblkonfdel" key="key">Hapus</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- begin pop detail -->
	<div id="popdetail" class="modal fade" role="dialog">
		<div class="modal-dialog modal-confirm">
			<div class="modal-content">
				<div class="modal-header">			
					<h4 class="modal-title">Detail Departemen</h4>	
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<table>
						<tr>
							<td>ID </td><td> : </td><td id="pop-id" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Nama Departemen </td><td> : </td><td id="pop-name" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Alamat </td><td> : </td><td id="pop-address" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Email </td><td> : </td><td id="pop-email" style="padding:10px;"></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal" id="batal-insert">Tutup</button>
				</div>
			</div>
		</div>
	</div>
	</section>
</body>

<script>
	$(document).ready(function(){
		
		$('.delete').on('click', function(){
			var id = $(this).attr('key-id');
			$('#hapus-id').val(id)
		});
		
		$('#tblkonfdel').on('click', function(){
			var id = $('#hapus-id').val();
			console.log('klik tombol hapus')
			$.ajax({
				url: '${pageContext.request.contextPath}/dep/delete/'+id,
				type : 'DELETE',
				success : function(response) {
					$('#konfirmdel').modal('hide');
					reloadTable();
					$('#konfirmdel').load('${pageContext.request.contextPath}/dep #konfirmdel')
				}, error : function(){
					
				}
			});
		}); // end fungsi delete
		
		function reloadTable(){
			$.ajax({
				url: '${pageContext.request.contextPath}/dep/get-all',
				type: "GET",
				dataType: "json",
				success:function(data) {
						$('#data-dep').DataTable().destroy();
						$('#isi-dep').empty();
						$.each(data, function(key, val) {
								$('#isi-dep').append('<tr><td>'+ val.id +'</td><td>'+ val.namaDepartemen +'</td><td>'+ val.alamat +'</td><td>'+ val.email +'</td>'
										+'<td><a href="#" key-id="'+val.id+'" class="tbldetail btn btn-success">Detail</a>' 
										+' | ' 
										+'<a href="#" key-id="'+val.id+'" class="tblupdate btn btn-info">Update</a>'
										+' | '
										+'<a href="#konfirmdel" data-toggle="modal" key-id="'+val.id+'" class="delete btn btn-danger">Delete</a>');
								
						});
						$('#data-dep').DataTable({
						      'paging'      : true,
						      'lengthChange': false,
						      'searching'   : true,
						      'ordering'    : true,
						      'info'        : true,
						      'autoWidth'   : false
						    });
				}
			});
		} // end fungsi reload table
		
		$('.tbladd').on('click', function(){
			$('#judul-modal').html('Tambah Data Departemen');
			$('#frminsert').modal('show');
			clearForm();
		});
		
		
		$('#tblsimpan').on('click', function(evt){
			console.log('click tombol simpan');
			evt.preventDefault();
			var id = $('#id').val();
			var name = $('#namaDepartemen').val();
			var address = $('#alamat').val();
			var email = $('#email').val();
			var departemen = {
					'id' : id,
					'namaDepartemen' : name,
					'alamat' : address,
					'email' : email
			};
			$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/dep/save',
				data : JSON.stringify(departemen),
				contentType : 'application/json',
				success : function(){
					$("#frminsert").modal("hide");
					console.log('simpan');
					reloadTable();
					clearForm();
					//alert('save '+ name + ' berhasil');
				}, error : function(){
					alert('save failed');
				}
			});
		}); // end fungsi simpan
		
		$('.tblupdate').on('click', function(){
			var id = $(this).attr('key-id');
			console.log('klik edit');
			$.ajax({
					url: '${pageContext.request.contextPath}/dep/get-one/'+id,
					type: "GET",
					dataType: "json",
					success:function(data) {	
						clearForm();
						console.log('sukses ambil data');
						$('#judul-modal').html('Update Data Departemen');
						$('#id').val(data.id);
						$('#namaDepartemen').val(data.namaDepartemen);
						$('#alamat').val(data.alamat);
						$('#email').val(data.email);
						$("#frminsert").modal("show");
					}
			});
		}); // end fungsi update
		
		$('.tbldetail').on('click', function(){
			var id = $(this).attr('key-id');
			console.log('klik detail');
			$.ajax({
					url: '${pageContext.request.contextPath}/dep/get-one/'+id,
					type: "GET",
					dataType: "json",
					success:function(data) {	
						clearForm();
						console.log('sukses ambil data');
						$('#pop-id').html(data.id);
						$('#pop-name').html(data.namaDepartemen);
						$('#pop-address').html(data.alamat);
						$('#pop-email').html(data.email);
						$("#popdetail").modal("show");
					}
			});
		}); // end fungsi detail
		
		$('.modalcancel').on('click', function(){
			$('#judul-modal').html('Tambahkan Data Departemen');
		});
		
		function clearForm() {
			$('#id').val('');
			$('#namaDepartemen').val('');
			$('#alamat').val('');
			$('#email').val('');
		}
	});
</script>
<script>
  $(function() {
    $('#data-dep').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
</script>
</html>