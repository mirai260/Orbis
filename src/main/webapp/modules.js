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
			parcours = data;
			for(i in parcours) {
				$("#Parcours").append('<div class="positionParcour" onClick="alert(\'coucou\');">'+parcours[i].nom+'</div>');
			}
		},
		error: function(data) {
			console.log(data);
		},
		contentType: "application/json; charset=utf-8",
		async: false
	})
});

function ajouteHTMLajoueconcept(){
	$("#ajouteConcept").empty();
	$("#ajouePrerequis").empty();
	$("#ajouteConcept").append('<div id="selectAjouteConcept"></div>');
	ajouteSelect1();
	
}

function ajouteSelect1(){
	var domainesCD;
	$.post('api/getAllConcepts', function(data) {
		domainesCD = data;
		for(i in domainesCD) {
			$("#selectAjouteConcept").append('<input type="checkbox" value="'+domainesCD[i].id_concept+'"/><label>'+domainesCD[i].nom+'</label><br>');
		}
	});
}

function ajouteHTMLajouePrerequis(){
	$("#ajouePrerequis").empty();
	$("#ajouteConcept").empty();
	$("#ajouePrerequis").append('<div id="selectAjoutePrerequis"></div>');
	ajouteSelect2();
	
}
function ajouteSelect2(){
	var domainesCD;
	$.get('api/getAllPrerequis', function(data) {
		domainesCD = data;
		for(i in domainesCD) {
			$("#selectAjoutePrerequis").append('<input type="checkbox" value="'+domainesCD[i].id_concept+'"/><label>'+domainesCD[i].nom+'</label><br>');
		}
	});
}