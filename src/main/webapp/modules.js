$(document).ready(function(){
	var token = sessionStorage.getItem("token");
	$.ajax({
		url: 'api/getParcoursOfConnectedProfesseur', 
		type: 'GET',
		data: "",
		headers: {
			"Authorization":"Bearer " + token,
			"Content-Type":"application/x-www-form-urlencoded; charset=utf-8"
		},
		success: function(data) {
			console.log(data);
		},
		error: function(data) {
			console.log(data);
		},
		contentType: "application/json; charset=utf-8",
		async: false
	})
	$.post('api/getAllConcepts', function(data) {
		parcours = data;
		for(i in parcours) {
			$("#Parcours").append('');
		}
	});
	});