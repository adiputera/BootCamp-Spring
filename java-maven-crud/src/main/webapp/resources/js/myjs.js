$(document).ready(function() {
	$("#simpan").on('click', function() {
		$.ajax({
			url : '/crud_bs/mhscontrol?action=insert',
			type : "post",
			data : {
				"nim" : $('#nim').val(),
				"nama" : $('#nama').val(),
				"alamat" : $('#alamat').val(),
				"univ" : $('#univ').val()
			},
			success : function(data) {
				$("#frminsert").modal("hide");
				refreshTable();
				clearForm();
			}
		});
	}); // end fungsi simpan

	function refreshTable() {
		$("#tablemhs").load("/crud_bs/ #tablemhs");
	} // end fungsi refresh table

	function clearForm() {
		$('#nim').val('');
		$('#nama').val('');
		$('#alamat').val('');
		$('#univ').val('');
	} // end fungsi clear form

	function passNim() {
		var nim = $(this).attr('key');
		$("#konfdel").attr('key', nim);
		console.log(nim);
	}

	$("#data-mhs").on('click', "#btn-del", function() {
		var nim = $(this).attr('key');
		$("#konfdel").attr('key', nim);
		console.log(nim);
	}); // end fungsi

	$("#konfdel").on('click', function() {
		var key = $(this).attr('key');
		$.ajax({
			url : '/crud_bs/mhscontrol?action=delete&nim=' + key,
			type : "GET",
			success : function(data) {
				$("#konfirmdel").modal("hide");
				refreshTable();
				$("#konfirmdel").load("/crud/bs #konfirmdel")
			}
		});
	}); // end fungsi del

});