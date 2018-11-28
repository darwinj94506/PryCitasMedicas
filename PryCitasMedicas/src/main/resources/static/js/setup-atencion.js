function loadWeek(){
	var criteria={
			"inicio":$("#dtpInicio").val(),
			"fin":$("#dtpInicio").val(),
			"idmedico":$("#cmbMedico").val()
	};
	
	$.ajax({
		url:"/atencion/week",
		method:"GET",
		dataType:"html",
		contentType:'aplication/json',
		data:JSON.stringify(criteria),
		success:function(html){
			$("#tblWeek").html(html);
		},
		error:function(err){
			console.log(err);
		}
	});
}

$(document).ready(function(){
	loadWeek();
	$('#dtpInicio').val(getToday());
	$('#dtpFin').val(getToday());
	loadWeek();
	$("#btnBuscar").click(function(){
		loadWeek()
	});
});

function getToday(){
	var now=new Date();
	var day=("0"+now.getDate()).slice(-2);
	var month=("0"+(now.getMonth()+1)).slice(-2);
	var today=now.getFullYear()+"-"+(month)+"-"+(day);
	return today;
}