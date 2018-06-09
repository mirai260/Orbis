var modules;
$.post('api/getModules', function(data) {
	domaines = data;
});
$(document).ready(function(){
	for(i in modules) {
		$("#module").append('<option value='+modules[i].name+'>'+modules[i].name+'</option>');
	}
});