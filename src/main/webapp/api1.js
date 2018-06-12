$(document).ready(function(){
	var domaines;
	var dom;
	var metiers;
	$.post('api/getDomaines', function(data) {
		domaines = data;
		for(i in domaines) {
			$("#domaine").append('<optgroup class="'+domaines[i].name+'" label='+domaines[i].name+'>');
			$.ajax({
				url: 'api/getMetiersByDomaine', 
				type: 'POST',
				data: domaines[i].name,
				success: function(data) {
					metiers = data;
					for(j in metiers) {
						$("optgroup."+domaines[i].name+"").append('<option value='+metiers[j].id_metier+'>'+metiers[j].nom+'</option>');
					}
				},
				contentType: "application/json; charset=utf-8",
				async: false
			});
		}
	});
	$("button.validation").click(function() {
		$("#APIParcours").empty();
		var listeMetiers = [];
		var parcours;
		var parcoursMatched;
		var metier = parseInt($("#domaine option:selected").val());
		listeMetiers.push(metier);
		console.log(listeMetiers);
		$.ajax({
			url: 'api/getParcoursByMetiers', 
			type: 'POST',
			data: JSON.stringify(listeMetiers),
			success: function(data) {
				parcoursMatched = data;
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			async: false
		});
		$.ajax({
			url: 'api/sortParcours', 
			type: 'POST',
			data: JSON.stringify(parcoursMatched),
			success: function(data) {
				parcours = data;
				for(i in parcours) {
					if(parcours[i].matched) {
						$("#APIParcours").append('<li class="parcour matched"><h2>'+parcours[i].parcours.nom+'</h2><div class="hide">'+parcours[i].parcours.description+'</div></li>');
					}
					else {
						$("#APIParcours").append('<li class="parcour"><h2>'+parcours[i].parcours.nom+'</h2><div class="hide">'+parcours[i].parcours.description+'</div></li>');
					}
				}
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			async: false
		});
//		$.ajax({
//			url: 'api/getAllParcours', 
//			type: 'GET',
//			success: function(data) {
//				parcours = data;
//				for(i in parcoursMatched) {
//					//console.log(parcoursMatched[i]);
//					$("#APIParcours").append('<li class="parcour matched"><h2>'+parcoursMatched[i].nom+'</h2><div class="hide">'+parcoursMatched[i].description+'</div></li>');
//				}
//				for(i in parcours) {
//					var res = false;
//					for(j in parcoursMatched) {
//						if(parcours[i].id_parcours == parcoursMatched[j].id_parcours) {
//							res = true;
//						}
//					}
//					if(!res) {
//						$("#APIParcours").append('<li class="parcour"><h2>'+parcours[i].nom+'</h2><div class="hide">'+parcours[i].description+'</div></li>');
//					}
//				}
//				parcoursMatched = null;
//				$(".accordeon .parcour").each(function() {
//					$(this).find("h2").click(function() {
//						if($(this).parent().find("div").is(":hidden")) {
//							$(this).parent().find("div").slideDown(200);
//						}
//						else {
//							$(this).parent().find("div").slideUp(200);
//						}
//					});
//				});
//			},
//			contentType: "application/json; charset=utf-8",
//			dataType: 'json'
//		});
	});
});

$( "#footer" ).load( "./Footer.html" );
