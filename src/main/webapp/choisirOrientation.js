function notation(arg) {
	if($("#" + arg).is(":checked")){
		$("#" + arg).next().after("<input name='level' type='range' min='1' max='5' value='2' step='1' onchange=shownumber('"+arg+"') />");
		$("#" + arg).next().next().after("<label id=number>2</label>");
	}
	else {
		$("#" + arg).next().next().remove();
		$("#" + arg).next().next().remove();
	}
}
function shownumber(arg){
	$("#" + arg).next().next().next().text($("#" + arg).next().next().val());
}

//var acc = document.getElementsByClassName("accordion");
//var i;
//
//for (i = 0; i < acc.length; i++) {
//  acc[i].addEventListener("click", function() {
//    this.classList.toggle("active");
//    var panel = this.nextElementSibling;
//    if (panel.style.maxHeight){
//      panel.style.maxHeight = null;
//    } else {
//      panel.style.maxHeight = panel.scrollHeight + "px";
//    }
//  });
//}

$(document).ready(function(){
	var domaines;
	var metiers;
	var dom;
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

		var domainesCD;
		$.get('api/getAllConcepts', function(data) {
			domainesCD = data;
			for(i in domainesCD) {
				$("#concept").append('<input type="checkbox" value="'+domainesCD[i].id_concept+'"/><label>'+domainesCD[i].nom+'</label><br>');
			}
		});
		var domainesCA;
		$.get('api/getAllPrerequis', function(data) {
			domainesCA = data;
			for(i in domainesCA) {
				$("#prerequis").append('<input type="checkbox" id="prerequis_' + domainesCA[i].id_prerequis + '" value="'+domainesCA[i].id_prerequis+'" onClick=notation(this.id) /><label>'+domainesCA[i].nom+'</label><br>');
			}
		});
	});

	
	$(".typeRecherche button.validation").click(function() {
		$("#APIParcours").empty();
		var listeMetiers = [];
		var listeConcepts = [];
		var listePrerequis = [];
		var parcours;
		var parcoursMatched;
		var optionMetier = $("#domaine option:selected").val();
		$("#concept input:checked").each(function() {
			listeConcepts.push($(this).val());
		});
		$("#prerequis input:checked").each(function() {
			listePrerequis.push($(this).val());
		});
		if(listeConcepts.length > 0) {
			$.ajax({
				url: 'api/getParcoursByConcepts', 
				type: 'POST',
				data: JSON.stringify(listeConcepts),
				success: function(data) {
					parcoursMatched = data;
				},
				contentType: "application/json; charset=utf-8",
				dataType: 'json',
				async: false
			});
		}
		else if(listePrerequis.length > 0) {
			$.ajax({
				url: 'api/getParcoursWithPrerequis', 
				type: 'POST',
				data: JSON.stringify(listePrerequis),
				success: function(data) {
					parcoursMatched = data;
				},
				contentType: "application/json; charset=utf-8",
				dataType: 'json',
				async: false
			});
		}
		else if(optionMetier != "default") {
			var metier = parseInt(optionMetier);
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
		}
		else {
			parcoursMatched = [];
		}
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

$( "footer" ).load( "./Footer.html" );
$('.deconnexion').click(function(){
  	sessionStorage.removeItem('token');
  });