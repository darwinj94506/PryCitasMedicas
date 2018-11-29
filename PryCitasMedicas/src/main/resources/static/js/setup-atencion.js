function loadWeek(){
	var criteria={
			"inicio":$("#dtpInicio").val(),
			"fin":$("#dtpInicio").val(),
			"id":$("#cmbMedico").val()
	};
	
	$.ajax({
		url:"/atencion/week/"+criteria.inicio+ "/" +criteria.fin + "/" +criteria.id,
		method:"GET",
		contentType:'aplication/json',
		dataType:"json",
		success:function(json){
			console.log(json);
		},
		error:function(err){
			console.log(err);
		}
	});
}


function loadTable(){
	loadWeek();
	$("#tblBodyWeek").find("td").each(function(index,value){
		var id=$(value).attr("id");
		if(id!=undefined){
			console.log(id);
		}
	});
}

function getToday(){
	var now=new Date();
	var day=("0"+now.getDate()).slice(-2);
	var month=("0"+(now.getMonth()+1)).slice(-2);
	var today=now.getFullYear()+"-"+(month)+"-"+(day);
	return today;
}

$(document).ready(function(){
	loadWeek();
	$('#dtpInicio').val(getToday());
	$('#dtpFin').val(getToday());
	$("#btnBuscar").click(function(){
		loadTable();
	});
});
