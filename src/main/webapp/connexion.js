

console.log("test");

function signin(){
	
	var username = $("#login").val();
	var password = $("#mdp").val();
	$("body").css("cursor", "progress");
	$("#submit").hide();
	$("#login").prop("disabled", true);
	$("#mdp").prop("disabled", true);
	$.ajax({
		url: "http://localhost:8080/oauth/token",
		type: 'POST',
		headers: {
			"Authorization":"Basic T3JiaXM6b3JiaXM=",
			"Content-Type":"application/x-www-form-urlencoded; charset=utf-8"
		},
		data: 'grant_type=password&username=' + username + '&password=' + password,
		success: function(result,status,xhr) {
			//$("body").css("cursor", "default");
			if (status == "success"){
				sessionStorage.setItem('token', result.access_token);
				redirect(result.access_token);
			}
		},
		error: function(xhr,status,error) {
			$("#submit").show();
			$("#login").prop("disabled", false);
			$("#mdp").prop("disabled", false);
			$("#mdp").val("");
			$("#error").html("Identifiant ou mot de passe incorrect");
			$("body").css("cursor", "default");
		}
	});
}







function redirect(token){
	console.log(token);
	$.ajax({
		url: 'api/getMyRole', 
		type: 'GET',
		data: "",
		headers: {
			"Authorization":"Bearer " + token,
			"Content-Type":"application/x-www-form-urlencoded; charset=utf-8"
		},
		success: function(data) {
			$("body").css("cursor", "default");
			var role = data.authority;
			if (role == "ROLE_ELEVE"){
				window.location.href = "choisirOrientation.html";
			}
			else if (role == "ROLE_PROFESSEUR"){
				window.location.href = "page_professeurs.html";
			}
			else if (role == "ROLE_ADMIN"){
				window.location.href = "Admin.html";
			}
			else{
				window.location.href = "accueil.html";
			}
		}
	})
}


