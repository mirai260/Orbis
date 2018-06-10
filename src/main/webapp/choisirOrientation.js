function notation(arg){
	if(document.getElementById("Cacquise"+arg).checked){
		document.getElementById(arg).innerHTML = "<input name='level"+
		arg+"' type='range' min='1' max='5' value='2' step='1' onchange=shownumber('"+arg+"')><p id='number"
		+arg+"'>2</p>";
	}
	else{
		document.getElementById(arg).innerHTML = "";
		}
	
}
function shownumber(arg){
	document.getElementById("number"+arg).innerHTML = document.getElementsByName("level"+arg)[0].value;
}

var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}

$(document).ready(function(){
	var domaines;
	var metiers;
	var dom;
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
					console.log("coucou");
					metiers = data;
					for(i in metiers) {
						$("#APIMetier").append('<option value='+metiers[i].idMetier+'>'+metiers[i].nom+'</option>');
					}
				},
				contentType: "application/json; charset=utf-8",
		});
	});
	var domainesCD;
	$.post('api/getAllConcepts', function(data) {
		domainesCD = data;
		console.log(data);
		for(i in domainesCD) {
			$("#Cdésire").append('<input type="checkbox" id="Cdesire'+domainesCD[i].nom+'" name="Cdesire'+domainesCD[i].nom+'" value="Cdesire'+domainesCD[i].nom+'">'+domainesCD[i].nom+'<br>');
		}
	});
	var domainesCA;
	$.get('api/getAllPrerequis', function(data) {
		domainesCA = data;
//		$("#Cacquise").append('<div class="skillLevel"><label>Java</label><input type="checkbox" id="CacquiseJava" name="CacquiseJava" value="Java" onclick=notation(this.value)><p id="Java"></p></div>');
		for(i in domainesCA) {
			$("#Cacquise").append('<div class="skillLevel"><label>Java</label><input type="checkbox" id="Cacquise'+domainesCA[i].nom+'" name="Cacquise'+domainesCA[i].nom+'" value="'+domainesCA[i].nom+'" onclick=notation(this.value)><p id="'+domainesCA[i].nom+'"></p></div> ');
		}
	});
	// A modifier
	$(".typeRecherche button.validation").click(function() {
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

function listMetier(){
	var oSelect = document.getElementById('APIMetier');
	oSelect.innerHTML = '';
	dom = $('#domaine option:selected').val();
	console.log(dom);
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
			dataType: 'json'
	});
	
}

//var parcour;
//$.post('api/getParcour',$('#metier').text(), function(data) {
//	parcour = data;
//});
//$(document).ready(function(){
//	for(i in parcour) {
//		$("#APIParcour").append('<button class="accordion">' +parcour[i].name +'</button><div class="panel"><p>'+parcour[i].description+'</p></div>');
//	}
//});
//
//$( "#footer" ).load( "http://localhost:8080/Footer.html" );
