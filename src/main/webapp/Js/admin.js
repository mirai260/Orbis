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
});

