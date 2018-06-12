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
				$("#APIParcours").css("border-style","groove");
				$("#APIParcours").css("border-radius","10px");
				$("#APIParcours").css("box-shadow","0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24)");
				parcoursMatched = null;
				$(".accordeon .parcour").each(function() {
					$(this).find("h2").click(function() {
						if($(this).parent().find("div").is(":hidden")) {
							$(this).parent().find("div").slideDown(200);
						}
						else {
							$(this).parent().find("div").slideUp(200);
						}
					});
				});
			},
			contentType: "application/json; charset=utf-8",
			dataType: 'json',
			async: false
		});
	});
});

$( "#footer" ).load( "./Footer.html" );
