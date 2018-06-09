$(document).ready(function(){
	var domaines;
	var dom;
	var metiers;
	$.post('api/getDomaines', function(data) {
		domaines = data;
		for(i in domaines) {
			$("#domaine").append('<option value='+domaines[i].name+'>'+domaines[i].name+'</option>');
		}
		dom = $('#domaine option:selected').val();
		console.log(dom);
		$.ajax({
			url: 'api/getMetiersByDomaine', 
			type: 'POST',
			data: dom,
			success: function(data) {
				metiers = data;
				for(i in metiers) {
					$("#APIMetier").append('<option value='+metiers[i].idMetier+'>'+metiers[i].nom+'</option>');
				}
			},
			contentType: "application/json; charset=utf-8"
		});
	});
	$("#domaine").change(function() {
		$("#APIMetier").empty();
		dom = $('#domaine option:selected').val();
		console.log(dom);
		$.ajax({
			url: 'api/getMetiersByDomaine', 
			type: 'POST',
			data: dom,
			success: function(data) {
				metiers = data;
				for(i in metiers) {
					$("#APIMetier").append('<option value='+metiers[i].idMetier+'>'+metiers[i].nom+'</option>');
				}
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json'
		});
	});
	$("#fromMetier button.validation").click(function() {
		var listeMetiers = [];
		var parcours;
		var metier = parseInt($("#APIMetier option:selected").val());
		console.log(metier);
		listeMetiers.push(metier);
		console.log(listeMetiers);
		$.ajax({
			url: 'api/getParcoursByMetiers', 
			type: 'POST',
			data: listeMetiers,
			success: function(data) {
				parcours = data;
				for(i in parcours) {
					console.log(parcours[i]);
					$("#APIParcours").append('<option value='+parcours[i].nom+'>'+parcours[i].nom+'</option>');
				}
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json'
		});
	});
});


//var metier;
//$.post('api/getMetiersByDomaine',$('#domaine').text(), function(data) {
//	metier = data;
//});
//$(document).ready(function(){
//	for(i in metier) {
//		$("#APIMetier").append('<input type="radio" name="metier" value='+metier[i].name+' checked>' +metier[i].name+ '<br>');
//	}
//});
//
//var parcour;
//$.post('api/getParcoursWithPrerequis',$('#metier').text(), function(data) {
//	parcour = data;
//});
//$(document).ready(function(){
//	for(i in parcour) {
//		$("#APIParcour").append('<button class="accordion">' +parcour[i].name +'</button><div class="panel"><p>'+parcour[i].description+'</p></div>');
//	}
//});

$( "#footer" ).load( "http://localhost:8080/Footer.html" );
