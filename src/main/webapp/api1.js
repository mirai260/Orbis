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
		$("#APIParcours").empty();
		var listeMetiers = [];
		var parcours;
		var metier = parseInt($("#APIMetier option:selected").val());
		listeMetiers.push(metier);
		console.log(listeMetiers);
		$.ajax({
			url: 'api/getParcoursByMetiers', 
			type: 'POST',
			data: JSON.stringify(listeMetiers),
			success: function(data) {
				parcours = data;
				for(i in parcours) {
					console.log(parcours[i]);
					$("#APIParcours").append('<li class="parcour"><h2>'+parcours[i].nom+'</h2><div class="hide">'+parcours[i].description+'</div></li>');
				}
				$(".accordeon .parcour").each(function() {
					$(this).find("h2").click(function() {
						$(".accordeon .parcours").find("div").each(function() {
							if(!$(this).parent().find("div").hasClass("hide")) {
								$(this).parent().find("div").addClass("hide");
							}
							$(this).slideUp(200);
						});
						if($(this).parent().find("div").hasClass("hide")) {
							$(this).parent().find("div").removeClass("hide");
							$(this).parent().find("div").slideDown(200);
						}
						else {
							$(this).parent().find("div").addClass("hide");
							$(this).parent().find("div").slideUp(200);
						}
					});
				});
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json'
		});
	});
});

$( "#footer" ).load( "http://localhost:8080/Footer.html" );
