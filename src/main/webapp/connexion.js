var identifiant = $("#user").val();
var mdp = $("#mdp").val();
var result;


$(document).ready(function(){

    $("#submit").click(function{

        $.post(
            'api/', {identifiant: identifiant,mdp: mdp}, function(result) 

            if(result==405) {
                alert("Nom d'utilisateur ou mot de passe erroné.");
            }
            elseif(result==200){

                sessionStorage.setitem("token", result)
            }



         );

    });

});


