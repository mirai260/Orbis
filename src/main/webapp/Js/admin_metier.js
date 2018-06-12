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
var	$data = $('#data');
var $description = $('description');
var	$nom = $('#nom');
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
		/*for(i=0; i<length(data); i++){
			console.log(data[i].nom);
		}*/
		//console.log(parcours.nom);
	}


});
$('.Liste_metier').click(function(){
	$('.metierliste').append("<input id='nom_metier' required value='nom du metier' type='text' name='nom_metier'>")

});
$.ajax("http://localhost:8080/api/getAllMetier", {
	success: function(data){
		$('#contenu').html(data);
		console.log(data[0].nom);
		for (var i=1; i<4; i++){
			$('.Liste_metier').append("<li class='metierliste'>"+data[i].nom+"</li>");
		}
		
		/*for(i=0; i<length(data); i++){
			console.log(data[i].nom);
		}*/
		
	}
});
/*$.ajax("http://localhost:8080/api/addMetier", {
	jQuery.post( url [, data ] [, success ] [, dataType ] )
	}*/
var tables = 
[
	//{nom : "Admin", colonnes : ["id_admin", "login", "mdp"], can_modify : true},
	//{nom : "Concept", colonnes : ["id_concept", "nom"], can_modify : true},
	{nom : "Domaine", colonnes : ["id_domaine", "name"], can_modify : true},
	//{nom : "Eleve", colonnes : ["id_eleve", "login", "mdp"], can_modify : true},
	{nom : "Metier", colonnes : ["id_metier", "nom", "description"], can_modify : true},
	{nom : "Metier_domaine", colonnes : ["id_metier_domaine", "id_domaine", "id_metier"], can_modify : false},
	//{nom : "Module_complementaire", colonnes : ["id_module", "nom", "description", "lien_fiche_module"], can_modify : true},
	//{nom : "Parcours", colonnes : ["id_parcours", "nom", "description"], can_modify : true},
	//{nom : "Prerequis", colonnes : ["id_prerequis", "nom", "description", "niveau", "note"], can_modify : true},
	//{nom : "Prerequis_parcours", colonnes : ["id_prerequis_parcours", "id_parcours", "id_prerequis"], can_modify : false},
	//{nom : "Professeur", colonnes : ["id_professeur", "login", "mdp"], can_modify : true}
];
function initialisation(){
	
	for (i in tables){
		var table = "<h3>" + tables[i].nom + "</h3><table id='table" + i + "'><tr>";
		for (j in tables[i].colonnes){
			table += "<th>" + tables[i].colonnes[j] + "</th>";
		}
		table += "</tr>";
		table += "<tr>";
		for (j in tables[i].colonnes){
			if (j == 0)
				table += "<td>" + "<input type='text' id='table" + i + "_colonne" + j + "' disabled/>" + "</td>";
			else
				table += "<td>" + "<input type='text' id='table" + i + "_colonne" + j + "'/>" + "</td>";
		}
		table += "<td>" + "<input type='submit' value='Ajouter' onclick='ajouter(" + i + ", " + tables[i].colonnes.length + ")'/>" + "</td>";
		table += "</tr>";
		table += "</table>"
		document.getElementById("bdd").innerHTML += table;
	}

	getAllData();
}

function getAllData(){
	for (i in tables){
		getData(i);
	}
}
function getData(i){
	var url = "http://localhost:8080/api/getAll" + tables[i].nom;
	var type="GET";
	$.ajax({
			type : type,
			url : url,
			headers : {"Content-Type": "application/json"},
			async : false,
			//dataType : 'application/json',
			success : function(data, statut){
				html = "";
				for (j in data){
					html += "<tr>";
					for (c in tables[i].colonnes){
						if (c == 0){
							html += "<td>" + data[j][tables[i].colonnes[c]] + "</td>";
						}
						else{
							html += "<td id='table" + i + "_ligne" + j + "_colonne" + c + "'>" + data[j][tables[i].colonnes[c]] + "</td>";
						}
					}
					html += "<td>" +
							"<a><img src='images/edit.ico' height='20' onclick='showEdit(" + i + ", " + j + ")'/></a>" +
							"<a><img src='images/delete.png' height='20' onclick='supprimer(" + i + ", " + data[j][tables[i].colonnes[0]] + ")'/></a>" +
							"</td>";
					html += "</tr>";
				}
				document.getElementById("table" + i).firstChild.firstChild.insertAdjacentHTML('afterend', html);
			}
	})
}

function emptyTable(i){
	table = "<tr>";
	for (j in tables[i].colonnes){
		table += "<th>" + tables[i].colonnes[j] + "</th>";
	}
	table += "</tr>";
	table += "<tr>";
	for (j in tables[i].colonnes){
		if (j == 0)
			table += "<td>" + "<input type='text' id='table" + i + "_colonne" + j + "' disabled/>" + "</td>";
		else
			table += "<td>" + "<input type='text' id='table" + i + "_colonne" + j + "'/>" + "</td>";
	}
	table += "<td>" + "<input type='submit' value='Ajouter' onclick='ajouter(" + i + ", " + tables[i].colonnes.length + ")'/>" + "</td>";
	table += "</tr>";
	document.getElementById("table" + i).innerHTML = table;
}

function showEdit(table, row){
	for (c in tables[table].colonnes){
		if (c != 0){
			document.getElementById("table" + table + "_ligne" + row + "_colonne" + c).innerHTML = "<input type='text' value='" + document.getElementById("table" + table + "_ligne" + row + "_colonne" + c).innerHTML + "'/>";
		}
	}
}




function supprimer(table, id){
	var url = "http://localhost:8080/api/delete" + tables[table].nom;
	var type="DELETE";
	var data="" + id;
	$.ajax({
			type : type,
			url : url, 
			data : data,
			async : false,
			headers : {"Content-Type": "application/json"}
	})
	emptyTable(table);
	getData(table);
}
function ajouter(table, nbr_colonnes){
	var data = {};
	for (i = 0; i < nbr_colonnes; i++){
		data[tables[table].colonnes[i]] = document.getElementById("table" + table + "_colonne" + i).value;
		console.log(document.getElementById("table" + table + "_colonne" + i).value);
	}
	console.log(data);
	
	var url = "http://localhost:8080/api/add" + tables[table].nom;
	console.log(url);
	var type="POST";
	$.ajax({
			type : type,
			url : url,
			async : false,
			data : JSON.stringify(data),
			headers : {"Content-Type": "application/json"}
	})
	emptyTable(table);
	getData(table);
}

$('document').ready(initialisation());


//console.log("coucou");


});

