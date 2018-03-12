<%@ include file="/WEB-INF/view/MasterPage/layout.jsp"%>
<h2><a href="${pageContext.request.contextPath}/emp">Data Tabel Employee</a></h2>
<section class="content">
<table  id="data-emp" class="table table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>alamat</th>
			<th>Email</th>
			
		</thead>
		<tbody id="isi-emp">
			<c:forEach items="${emps }" var="emp">
				<tr>
					<td>${emp.id }</td>
					<td>${emp.name }</td>
					<td>${emp.address }</td>
					<td>${emp.email }</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2><a href="${pageContext.request.contextPath}/mhs">Data Tabel Mahasiswa</a></h2>
	<table  id="data-mhs" class="table table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Nama</th>
			<th>Alamat</th>
			<th>Universitas</th>
			
		</thead>
		<tbody id="isi-mhs">
			<c:forEach items="${mhs }" var="mh">
				<tr>
					<td>${mh.nim }</td>
					<td>${mh.nama }</td>
					<td>${mh.alamat }</td>
					<td>${mh.univ }</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h2><a href="${pageContext.request.contextPath}/dep">Data Tabel Departemen</a></h2>
	<table  id="data-dep" class="table table-bordered table-hover">
		<thead>
			<th>ID</th>
			<th>Nama Departemen</th>
			<th>Alamat</th>
			<th>Email</th>
			
		</thead>
		<tbody id="isi-dep">
			<c:forEach items="${deps }" var="dep">
				<tr>
					<td>${dep.id }</td>
					<td>${dep.namaDepartemen }</td>
					<td>${dep.alamat }</td>
					<td>${dep.email }</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table> 
	</section>
	<script>
  $(function() {
    $('#data-emp').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false,
      'pageLength'  : 5
    });
    $('#data-mhs').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false,
      'pageLength'  : 5
    });
    $('#data-dep').DataTable({
        'paging'      : true,
        'lengthChange': false,
        'searching'   : true,
        'ordering'    : true,
        'info'        : true,
        'autoWidth'   : false,
        'pageLength'  : 5
      })
  })
</script>