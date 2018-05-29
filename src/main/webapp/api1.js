var domaines;
$.post('api/getDomaines', function(data) {
	domaines = data;
	console.log(domaines);
});
$(document).ready(function(){
//	for(domaine)
//	$("#domaine").append
});