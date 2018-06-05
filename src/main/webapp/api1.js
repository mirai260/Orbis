var domaines;
$.post('api/getDomaines', function(data) {
	domaines = data;
});
$(document).ready(function(){
	for(i in domaines) {
		$("#domaine").append('<option value='+domaines[i].name+'>'+domaines[i].name+'</option>');
	}
});