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
				$("#Parcours").append('<div class="positionParcour" onClick="Concept('+parcours[i].id_parcours+');Prerequis('+parcours[i].id_parcours+');">'+parcours[i].nom+'</div>');
			}
		},
		error: function(data) {
			console.log(data);
		},
		contentType: "application/json; charset=utf-8",
		async: false
	})
});

/*#########################################################################*/

var Parcours;
function Concept(val){
	Parcours=val;
	$("#ConceptsParcours").empty();
	var data = "" + val;
	$.ajax({
		url: 'api/getConceptsOfParcours', 
		type: 'POST',
		data: data,
		contentType: "application/json; charset=utf-8",
		success: function(data) {
			console.log(data);
			parcours = data;
			for(i in parcours) {
				$("#ConceptsParcours").append('<input type="checkbox" id="'+parcours[i].id_concept+'" />'+parcours[i].nom+'<br>');
			}
		},
		error: function(data) {
			console.log(data);
		}
	})
}

function Prerequis(val){
	var data = "" + val;
	$("#ConceptsPrerequi").empty();
	$.ajax({
		url: 'api/getPrerequisOfParcours', 
		type: 'POST',
		data: data,
		contentType: "application/json; charset=utf-8",
		success: function(data) {
			console.log(data);
			parcours = data;
			for(i in parcours) {
				console.log('<input type="checkbox" id='+parcours[i].id_prerequis+' />'+parcours[i].nom+'<br>');
				$("#ConceptsPrerequi").append('<input type="checkbox" id="'+parcours[i].id_prerequis+'" />'+parcours[i].nom+'<br>');
			}
		},
		error: function(data) {
			console.log(data);
		},
		async: false
	})
}

function ajoutePrerequi(){
	$('#selectAjoutePrerequis input').each(function() {
		if ($(this).is(':checked')){
			console.log($(this));
			var data = {id_parcours : Parcours, id_prerequis : $(this).attr('id')};
			console.log(JSON.stringify(data));
			$.ajax({
				url: 'api/setPrerequisToParcours', 
				type: 'POST',
				data: JSON.stringify(data),
				//headers : {"Content-Type": "application/json"},
				success: function(data) {
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				},
				contentType: "application/json; charset=utf-8"
			})
		}
	});
	window.location.href = "page_professeurs.html";
	
	
}

function ajouteConcept(){
	console.log("test");
	$('#selectAjouteConcept input').each(function() {
		if ($(this).is(':checked')){
			console.log($(this));
			var data = {id_parcours : Parcours, id_concept : $(this).attr('id')};
			console.log(JSON.stringify(data));
			$.ajax({
				url: 'api/setConceptToParcours', 
				type: 'POST',
				data: JSON.stringify(data),
				//headers : {"Content-Type": "application/json"},
				success: function(data) {
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				},
				contentType: "application/json; charset=utf-8"
			})
		}
	});
	window.location.href = "page_professeurs.html";
	
	
}

/*#########################################################################*/

function ajouteHTMLajoueconcept(){
	$("#ajouteConcept").empty();
	$("#ajouePrerequis").empty();
	$("#ajouteConcept").append('<div id="selectAjouteConcept"></div> <button type="button" onClick="ajouteConcept();">ajouter</button>');
	ajouteSelect1();
	
}

function ajouteSelect1(){
	var domainesCD;
	$.get('api/getAllConcepts', function(data) {
		domainesCD = data;
		for(i in domainesCD) {
			$("#selectAjouteConcept").append('<input type="checkbox" id="'+domainesCD[i].id_concept+'"/><label>'+domainesCD[i].nom+'</label><br>');
		}
	});
}

function ajouteHTMLajouePrerequis(){
	$("#ajouePrerequis").empty();
	$("#ajouteConcept").empty();
	$("#ajouePrerequis").append('<div id="selectAjoutePrerequis"></div><br> <button type="button" onClick="ajoutePrerequi();">ajouter</button> ');
	ajouteSelect2();
	
}
function ajouteSelect2(){
	var domainesCD;
	$.get('api/getAllPrerequis', function(data) {
		domainesCD = data;
		for(i in domainesCD) {
			$("#selectAjoutePrerequis").append('<input type="checkbox" id="'+domainesCD[i].id_prerequis+'"/><label>'+domainesCD[i].nom+'</label><br>');
		}
	});
}

/*############################Suprimer#################################################*/

function suprimerConcept(){
	$('#ConceptsParcours input').each(function() {
		if ($(this).is(':checked')){
			console.log($(this));
			var data = {id_parcours : Parcours, id_concept : $(this).attr('id')};
			console.log(JSON.stringify(data));
			$.ajax({
				url: 'api/removeConceptFromParcours', 
				type: 'DELETE',
				data: JSON.stringify(data),
				//headers : {"Content-Type": "application/json"},
				success: function(data) {
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				},
				contentType: "application/json; charset=utf-8"
			})
		}
	});
	window.location.href = "page_professeurs.html";
}

function suprimerPrerequi(){
	$('#ConceptsPrerequi input').each(function() {
		if ($(this).is(':checked')){
			console.log($(this));
			var data = {id_parcours : Parcours, id_prerequis : $(this).attr('id')};
			console.log(JSON.stringify(data));
			$.ajax({
				url: 'api/removePrerequisFromParcours', 
				type: 'DELETE',
				data: JSON.stringify(data),
				//headers : {"Content-Type": "application/json"},
				success: function(data) {
					console.log(data);
				},
				error: function(data) {
					console.log(data);
				},
				contentType: "application/json; charset=utf-8"
			})
		}
	});
	window.location.href = "page_professeurs.html";
}