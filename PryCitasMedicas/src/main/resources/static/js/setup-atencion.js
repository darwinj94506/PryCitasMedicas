function loadData() {
	var criteria = {
		inicio : $("#dtpInicio").val(),
		fin : $("#dtpFin").val(),
		idmedico : $("#idMedico").val()
	};
	
	$.ajax({		
		url : "/atencion/agenda",
		method : "POST",
		contentType : "application/json",
		dataType : "json",
		data : JSON.stringify(criteria),
		success : function(json) {
			console.log(json);
		},
		error : function(err) {
			console.log(err);
		}
	});
}

function loadTable() {
	$("#tblBodyWeek").find("td").each(function(index, value) {
		var id = $(value).attr("id");
		if (id != undefined) {
			console.log(id);
		}
	});
}

function updateMedicalAppointment(){
	
}


function setupCalendar() {

	$("#tblCalendar").fullCalendar(
			{
				defaultView : 'agendaWeek',
				themeSystem : 'bootstrap4',
				header : {
					left : 'prev,next',
					center : 'title',
					right : ''
				},
				minTime : '08:00:00',
				maxTime : '17:00:00',
				monthNamesShort : [ 'Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
						'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic' ],
				dayNamesShort : [ 'Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie',
						'Sab' ],
				firstDay : 1,
				defaultDate : new Date(),
				navLinks : true, 
				editable : true,
				eventLimit : true,
				height : 600,
				allDayText : 'Hora',
				eventClick:  function(event, jsEvent, view) {
		            $('#title').html(event.title);
		            $('#description').html(event.description);		            
		            $('#MedicalAppointment').modal();
		        },
				events: [
				    {
				      title  : 'Juan Pérez',
				      start  : '2018-12-05 09:00:00',
				      end  : '2018-12-05 09:30:00',
				      description : 'PEDIATRÍA - Anita Mejía'
				    },
				    {
				      title  : 'Tatiana Pérez',
				      start  : '2018-12-05 09:30:00',
				      end  : '2018-12-05 10:00:00',
				      description : 'PEDIATRÍA - Anita Mejía'
				    	  
				    },
				    {
				      title  : 'Miguel Pérez',
				      start  : '2018-12-06 12:30:00',
				      end  : '2018-12-06 13:00:00',
				      description : 'PEDIATRÍA - Anita Mejía'
				    }
				  ]
			});
}

$(document).ready(function() {
	setupCalendar();	
});
