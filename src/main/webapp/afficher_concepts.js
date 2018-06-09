var p1 = document.querySelector('#module1');
var p2 = document.querySelector('#module2');

p1.addEventListener('click', afficherConcepts1);
p2.addEventListener('click', afficherConcepts2);

function afficherConcepts1()
{
  if (document.getElementById('concepts1').style.display == 'none') {
       document.getElementById('concepts1').style.display = 'block';
  }
  else {
       document.getElementById('concepts1').style.display = 'none';
  }
}

function afficherConcepts2()
{
  if (document.getElementById('concepts2').style.display == 'none') {
       document.getElementById('concepts2').style.display = 'block';
  }
  else {
       document.getElementById('concepts2').style.display = 'none';
  }
}