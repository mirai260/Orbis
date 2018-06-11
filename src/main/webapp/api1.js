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
						$("optgroup."+domaines[i].name+"").append('<option value='+metiers[j].idMetier+'>'+metiers[j].nom+'</option>');
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
		var metier = parseInt($("#domaine option:selected").val());
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
			dataType: 'json'
		});
	});
});

$( "#footer" ).load( "./Footer.html" );
