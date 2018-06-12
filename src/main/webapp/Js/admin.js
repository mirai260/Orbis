jQuery(document).ready(function($) {
   /*function classToggle() {
      const navs = document.querySelectorAll('.Navbar__Items')
  
      navs.forEach(nav => nav.classList.toggle('Navbar__ToggleShow'));
  }*/
  function classToggleJob() {
  	if($('.Metier #metier_a_ajouter').hasClass('Metier_affiche')){
  		$('.Metier_affiche').addClass('Nouveau_metier').removeClass('Metier_affiche');


  	}
  	else{
  		$('.Nouveau_metier').addClass('Metier_affiche').removeClass('Nouveau_metier');
  		

  	}
  	
  }


  //document.querySelector('.Navbar__Link-toggle');
  //console.log(document.querySelector('.Navbar__Link-toggle'));

  //document.querySelector('.Navbar__Link-toggle').addEventListener('click', classToggle);

  $('.ajout_metier').click(function() {
  	classToggleJob();
  });
var url = "http://localhost:8080/api/getAllParcours";
//var data = {"nom", "description"};
var type="GET";
/*$.ajax({
		type : type,
		url : url,
		data : JSON.stringify(data),
		headers : {"Content-Type": "application/json"},
		success : function(data, statut){
			console.log(data);
		}
})*/
$.ajax("http://localhost:8080/api/getAllParcours", {
	success: function(data){
		$('#contenu').html(data);
		console.log(data[0].nom);
		for(i=0; i<length(data); i++){
			console.log(data[i].nom);
		}
		//console.log(parcours.nom);
	}


});
//console.log("coucou");


});

