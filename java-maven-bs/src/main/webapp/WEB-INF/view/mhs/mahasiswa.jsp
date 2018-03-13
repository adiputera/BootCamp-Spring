<%@ include file="/WEB-INF/view/MasterPage/layout.jsp"%>
<section class="content">	
	<h2>Data Mahasiswa</h2>
	<button type="button" class="tbladd btn btn-info btn-lg">Tambah Mahasiswa</button>
	<table  id="data-mhs" class="table table-striped table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Nama</th>
			<th>Alamat</th>
			<th>Universitas</th>
			<th>Action</th>
		</thead>
		<tbody id="isi-mhs">
			<c:forEach items="${mhs }" var="mh">
				<tr>
					<td>${mh.nim }</td>
					<td>${mh.nama }</td>
					<td>${mh.alamat }</td>
					<td>${mh.univ }</td>
					<td>
						<a href="#" key-id="${mh.nim }" class="tbldetail btn btn-success">Detail</a>
						|
						<a href="#" key-id="${mh.nim }" class="tblupdate btn btn-info">Update</a>
						|
						<a href="#konfirmdel" data-toggle="modal" key-id="${mh.nim }" class="delete btn btn-danger">Delete</a> 
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> <!-- end table employee -->
	
	<!-- begin form save -->
	<div class="modal fade" id="frminsert" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					
					<button type="button" class="close modalcancel" data-dismiss="modal">&times;</button>
					<h4 id="judul-modal">Tambahkan Mahasiswa</h4>
				</div>
				<div class="modal-body">
					<form data-parsley-validate method="post">
						<table>
							<tr>
								<td>Nama</td>
								<td>:</td>
								<td><input type="text" name="nama" id="nama" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td>Alamat</td>
								<td>:</td>
								<td><input type="text" name="alamat" id="alamat" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td>Universitas</td>
								<td>:</td>
								<td><input type="email" name="univ" id="univ" data-parsley-minlength="1"/></td>
							</tr>
							<tr>
								<td colspan="2"><button type="button" class="btn btn-primary" id="tblsimpan">Simpan</button></td>
								<td><input type="hidden" name="nim" id="nim"></td>
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
					<h4 class="modal-title">Detail Employee</h4>	
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<table>
						<tr>
							<td>ID </td><td> : </td><td id="pop-id" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Nama </td><td> : </td><td id="pop-name" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Alamat </td><td> : </td><td id="pop-address" style="padding:10px;"></td>
						</tr>
						<tr>
							<td>Universitas </td><td> : </td><td id="pop-univ" style="padding:10px;"></td>
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
		
		$('#data-mhs').on('click', '.delete',function(){
			var id = $(this).attr('key-id');
			$('#tblkonfdel').attr('key', id);
			
		});
		
		$('#tblkonfdel').on('click', function(){
			var id = $(this).attr('key');
			console.log('klik tombol hapus')
			$.ajax({
				url: '${pageContext.request.contextPath}/mhs/delete/'+id,
				type : 'DELETE',
				success : function(response) {
					$('#konfirmdel').modal('hide');
					reloadTable();
					$('#konfirmdel').load('${pageContext.request.contextPath}/mhs #konfirmdel')
				}, error : function(){
					
				}
			});
		}); // end fungsi delete
		
		function reloadTable(){
			$.ajax({
				url: '${pageContext.request.contextPath}/mhs/get-all',
				type: "GET",
				dataType: "json",
				success:function(data) {
						$('#data-mhs').DataTable().destroy();
						$('#isi-mhs').empty();
						$.each(data, function(key, val) {
								$('#isi-mhs').append('<tr><td>'+ val.nim +'</td><td>'+ val.nama +'</td><td>'+ val.alamat +'</td><td>'+ val.univ +'</td>'
										+'<td><a href="#" key-id="'+val.nim+'" class="tbldetail btn btn-success">Detail</a>' 
										+' | ' 
										+'<a href="#" key-id="'+val.nim+'" class="tblupdate btn btn-info">Update</a>'
										+' | '
										+'<a href="#konfirmdel" data-toggle="modal" key-id="'+val.nim+'" class="delete btn btn-danger">Delete</a>');
								
						});
						$('#data-mhs').DataTable({
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
			$('#judul-modal').html('Tambah Data Mahasiswa');
			$('#frminsert').modal('show');
			clearForm();
		});
		
		
		$('#tblsimpan').on('click', function(evt){
			console.log('click tombol simpan');
			evt.preventDefault();
			var nim = $('#nim').val();
			var nama = $('#nama').val();
			var alamat = $('#alamat').val();
			var univ = $('#univ').val();
			var mahasiswa = {
					'nim' : nim,
					'nama' : nama,
					'alamat' : alamat,
					'univ' : univ
			};
			$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/mhs/save',
				data : JSON.stringify(mahasiswa),
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
		
		$('#data-mhs').on('click', '.tblupdate',function(){
			var id = $(this).attr('key-id');
			console.log('klik edit');
			$.ajax({
					url: '${pageContext.request.contextPath}/mhs/get-one/'+id,
					type: "GET",
					dataType: "json",
					success:function(data) {	
						clearForm();
						console.log('sukses ambil data');
						$('#judul-modal').html('Update Data Mahasiswa');
						$('#nim').val(data.nim);
						$('#nama').val(data.nama);
						$('#alamat').val(data.alamat);
						$('#univ').val(data.univ);
						$("#frminsert").modal("show");
					}
			});
		}); // end fungsi update
		
		$('#data-mhs').on('click', '.tbldetail',function(){
			var id = $(this).attr('key-id');
			console.log('klik detail');
			$.ajax({
					url: '${pageContext.request.contextPath}/mhs/get-one/'+id,
					type: "GET",
					dataType: "json",
					success:function(data) {	
						clearForm();
						console.log('sukses ambil data');
						$('#pop-id').html(data.nim);
						$('#pop-name').html(data.nama);
						$('#pop-address').html(data.alamat);
						$('#pop-univ').html(data.univ);
						$("#popdetail").modal("show");
					}
			});
		}); // end fungsi detail
		
		$('.modalcancel').on('click', function(){
			$('#judul-modal').html('Tambahkan Data Mahasiswa');
		});
		
		function clearForm() {
			$('#nim').val('');
			$('#nama').val('');
			$('#alamat').val('');
			$('#univ').val('');
		}
	});
</script>
<script>
  $(function() {
    $('#data-mhs').DataTable({
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