function checkRole(role){
	var token = sessionStorage.getItem('token');
	if (token == null)
		window.location.href = "accueil.html";
	$.ajax({
		url: 'api/getMyRole', 
		type: 'GET',
		data: "",
		async: false,
		headers: {
			"Authorization":"Bearer " + token,
			"Content-Type":"application/x-www-form-urlencoded; charset=utf-8"
		},
		success: function(data) {
			var r = data.authority;
			if (r != role){
				window.location.href = "accueil.html";
			}
		}
	});
}