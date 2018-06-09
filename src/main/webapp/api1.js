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
//		$.post('api/getMetiersByDomaine', {
//				domaine: dom },
//				function(data) {
//					console.log("coucou");
//					metiers = data;
//					for(i in metiers) {
//						$("#APIMetier").append('<option value='+metiers[i].nom+'>'+metiers[i].nom+'</option>');
//					}
//				}
//		);
		$.ajax({
			url: 'api/getMetiersByDomaine', 
			type: 'POST',
			data: dom,
			success: function(data) {
				console.log("coucou");
				metiers = data;
				for(i in metiers) {
					$("#APIMetier").append('<option value='+metiers[i].nom+'>'+metiers[i].nom+'</option>');
				}
			},
			contentType: "application/json; charset=utf-8",
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
