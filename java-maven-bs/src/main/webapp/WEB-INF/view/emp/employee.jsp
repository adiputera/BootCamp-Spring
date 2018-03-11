<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Data Tables</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/Ionicons/css/ionicons.min.css">
  <!-- DataTables -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/elements.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
 
<script>
	$(document).ready(function(){
		
		$('.delete').on('click', function(){
			var id = $(this).attr('id');
			$('#tblkonfdel').attr('key', id)
		});
		
		$('#tblkonfdel').on('click', function(){
			var id = $(this).attr('key');
			console.log('klik tombol hapus')
			$.ajax({
				url: '${pageContext.request.contextPath}/emp/delete/'+id,
				type : 'DELETE',
				success : function(response) {
					$('#konfirmdel').modal('hide');
					reloadTable();
					$('#konfirmdel').load('${pageContext.request.contextPath}/emp #konfirmdel')
				}, error : function(){
					
				}
			});
		}); // end fungsi delete
		
		function reloadTable(){
			$.ajax({
				url: '${pageContext.request.contextPath}/emp/get-all',
				type: "GET",
				dataType: "json",
				success:function(data) {
						$('#data-emp').DataTable().destroy();
						$('#isi-emp').empty();
						$.each(data, function(key, val) {
								$('#isi-emp').append('<tr><td>'+ val.id +'</td><td>'+ val.name +'</td><td>'+ val.address +'</td><td>'+ val.email +'</td>'
										+'<td><a href="#konfirmdel" data-toggle="modal" id="'+val.id+'" class="delete btn btn-danger">Delete</a>' 
										+'|' 
										+'<a href="#" id="'+val.id+'" class="tblupdate btn btn-info">Update</a></td>');
								
						});
						$('#data-emp').DataTable({
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
			$('#judul-modal').html('Tambah Data Employee');
			$('#frminsert').modal('show');
			clearForm();
		});
		
		
		$('#tblsimpan').on('click', function(evt){
			console.log('click tombol simpan');
			evt.preventDefault();
			var id = $('#id').val();
			var name = $('#name').val();
			var address = $('#address').val();
			var email = $('#email').val();
			var employee = {
					'id' : id,
					'name' : name,
					'address' : address,
					'email' : email
			};
			$.ajax({
				type : 'post',
				url : '${pageContext.request.contextPath}/emp/save',
				data : JSON.stringify(employee),
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
			var id = $(this).attr('id');
			console.log('klik edit');
			$.ajax({
					url: '${pageContext.request.contextPath}/emp/get-one/'+id,
					type: "GET",
					dataType: "json",
					success:function(data) {	
						clearForm();
						console.log('sukses ambil data');
						$('#judul-modal').html('Update Data Employee');
						$('#id').val(data.id);
						$('#name').val(data.name);
						$('#address').val(data.address);
						$('#email').val(data.email);
						$("#frminsert").modal("show");
					}
			});
		}); // end fungsi update
		
		$('.modalcancel').on('click', function(){
			$('#judul-modal').html('Tambahkan Data Employee');
		});
		
		function clearForm() {
			$('#id').val('');
			$('#name').val('');
			$('#address').val('');
			$('#email').val('');
		}
	});
</script>
</head>
<body>
	<header class="main-header">
        <a href="${pageContext.request.contextPath}/resources/index2.html" class="logo">
          <!-- LOGO -->
          AdminLTE
        </a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
              <!-- Messages: style can be found in dropdown.less-->
              <li class="dropdown messages-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-envelope-o"></i>
                  <span class="label label-success">4</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 4 messages</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- start message -->
                        <a href="#">
                          <div class="pull-left">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                          </div>
                          <h4>
                            Sender Name
                            <small><i class="fa fa-clock-o"></i> 5 mins</small>
                          </h4>
                          <p>Message Excerpt</p>
                        </a>
                      </li><!-- end message -->
                      ...
                    </ul>
                  </li>
                  <li class="footer"><a href="#">See All Messages</a></li>
                </ul>
              </li>
              <!-- Notifications: style can be found in dropdown.less -->
              <li class="dropdown notifications-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-bell-o"></i>
                  <span class="label label-warning">10</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 10 notifications</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li>
                        <a href="#">
                          <i class="ion ion-ios-people info"></i> Notification title
                        </a>
                      </li>
                      ...
                    </ul>
                  </li>
                  <li class="footer"><a href="#">View all</a></li>
                </ul>
              </li>
              <!-- Tasks: style can be found in dropdown.less -->
              <li class="dropdown tasks-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <i class="fa fa-flag-o"></i>
                  <span class="label label-danger">9</span>
                </a>
                <ul class="dropdown-menu">
                  <li class="header">You have 9 tasks</li>
                  <li>
                    <!-- inner menu: contains the actual data -->
                    <ul class="menu">
                      <li><!-- Task item -->
                        <a href="#">
                          <h3>
                            Design some buttons
                            <small class="pull-right">20%</small>
                          </h3>
                          <div class="progress xs">
                            <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                              <span class="sr-only">20% Complete</span>
                            </div>
                          </div>
                        </a>
                      </li><!-- end task item -->
                      ...
                    </ul>
                  </li>
                  <li class="footer">
                    <a href="#">View all tasks</a>
                  </li>
                </ul>
              </li>
              <!-- User Account: style can be found in dropdown.less -->
              <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                  <span class="hidden-xs">Alexander Pierce</span>
                </a>
                <ul class="dropdown-menu">
                  <!-- User image -->
                  <li class="user-header">
                    <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    <p>
                      Alexander Pierce - Web Developer
                      <small>Member since Nov. 2012</small>
                    </p>
                  </li>
                  <!-- Menu Body -->
                  <li class="user-body">
                    <div class="col-xs-4 text-center">
                      <a href="#">Followers</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Sales</a>
                    </div>
                    <div class="col-xs-4 text-center">
                      <a href="#">Friends</a>
                    </div>
                  </li>
                  <!-- Menu Footer-->
                  <li class="user-footer">
                    <div class="pull-left">
                      <a href="#" class="btn btn-default btn-flat">Profile</a>
                    </div>
                    <div class="pull-right">
                      <a href="#" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </nav>
      </header>
	<button type="button" class="tbladd btn btn-info btn-lg">Tambah Employee</button>
	<table  id="data-emp" class="table table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>alamat</th>
			<th>Email</th>
			<th>Action</th>
		</thead>
		<tbody id="isi-emp">
			<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.address }</td>
					<td>${emp.email }</td>
					<td>
						<a href="#konfirmdel" data-toggle="modal" id="${emp.id }" class="delete btn btn-danger">Delete</a> 
						| 
						<a href="#" id="${emp.id }" class="tblupdate btn btn-info">Update</a>
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
					<h4 id="judul-modal">Tambahkan Employee</h4>
				</div>
				<div class="modal-body">
					<form method="post">
						<table>
							<tr>
								<td>Nama</td>
								<td>:</td>
								<td><input type="text" name="name" id="name" /></td>
							</tr>
							<tr>
								<td>Alamat</td>
								<td>:</td>
								<td><input type="text" name="address" id="address"/></td>
							</tr>
							<tr>
								<td>Email</td>
								<td>:</td>
								<td><input type="email" name="email" id="email" /></td>
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
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal" id="batal-insert">Batal</button>
					<button type="button" class="btn btn-danger" id="tblkonfdel" key="key">Hapus</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="${pageContext.request.contextPath}/resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/resources/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="${pageContext.request.contextPath}/resources/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/resources/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/resources/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath}/resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
  $(function() {
    $('#example1').DataTable()
    $('#data-emp').DataTable({
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