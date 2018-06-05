jQuery(document).ready(function($) {
   function classToggle() {
      const navs = document.querySelectorAll('.Navbar__Items')
  
      navs.forEach(nav => nav.classList.toggle('Navbar__ToggleShow'));
  }


  //document.querySelector('.Navbar__Link-toggle');
  console.log(document.querySelector('.Navbar__Link-toggle'));

  document.querySelector('.Navbar__Link-toggle').addEventListener('click', classToggle);
});

