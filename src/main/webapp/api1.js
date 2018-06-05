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
		$("#fromMetier").append('<input type="radio" name="metier" value='+metier[i].name+' checked>' +metier[i].name+ '<br>');
	}
});