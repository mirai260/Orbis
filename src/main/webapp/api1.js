var domaines;
$.post('api/getDomaines', function(data) {
	domaines = data;
});
$(document).ready(function(){
	for(i in domaines) {
		$("#domaine").append('<option value='+domaines[i].name+'>'+domaines[i].name+'</option>');
	}
});


var metier;
$.post('api/getMetier',$('#domaine').text(), function(data) {
	metier = data;
});
$(document).ready(function(){
	for(i in metier) {
		$("#APIMetier").append('<input type="radio" name="metier" value='+metier[i].name+' checked>' +metier[i].name+ '<br>');
	}
});

var parcour;
$.post('api/getParcour',$('#metier').text(), function(data) {
	parcour = data;
});
$(document).ready(function(){
	for(i in parcour) {
		$("#APIParcour").append('<button class="accordion">' +parcour[i].name +'</button><div class="panel"><p>'+parcour[i].description+'</p></div>');
	}
});

$( "#body" ).load( "http://localhost:8080/Footer.html" );