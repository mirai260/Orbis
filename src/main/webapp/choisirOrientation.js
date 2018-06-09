function notation(arg){
	if(document.getElementById("Cacquise"+arg).checked){
		document.getElementById(arg).innerHTML = "<input name='level"+
		arg+"' type='range' min='1' max='5' value='2' step='1' onchange=shownumber('"+arg+"')><p id='number"
		+arg+"'>2</p>";
	}
	else{
		document.getElementById(arg).innerHTML = "";
		}
	
}
function shownumber(arg){
	document.getElementById("number"+arg).innerHTML = document.getElementsByName("level"+arg)[0].value;
}

var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.maxHeight){
      panel.style.maxHeight = null;
    } else {
      panel.style.maxHeight = panel.scrollHeight + "px";
    }
  });
}

/*function metier(){
	var domainesMetier;
	$.post('api/getDomainesMetier', function(data) {
		domainesMetier = data;
		for(i in domainesMetier) {
			$("#metier").append('<option value='+domainesMetier[i].name+'>'+domainesMetier[i].name+'</option>');
		}
	});
}*/

/*function competanceDésire(){
	var domainesCD;
	$.post('api/getDomainesCD', function(data) {
		domainesCD = data;
		for(i in domainesMetier) {
			$("#Cdésire").append('<label>'+domainesCD[i].name+'</label><input type="checkbox" name="Cfavorite" value='+domainesCD[i].name+'>');
		}
	});
}*/

$(document).ready(function(){
	var domaines;
	var metiers;
	var dom;
	$.post('api/getDomaines', function(data) {
		domaines = data;
		for(i in domaines) {
			$("#domaine").append('<option value='+domaines[i].name+'>'+domaines[i].name+'</option>');
		}
		dom = $('#domaine option:selected').val();
		console.log(dom);
		$.ajax({
				url: 'api/getMetiersByDomaine', 
				type: 'POST',
				data: "domaine=Informatique",
				success: function(data) {
					console.log("coucou");
					metiers = data;
					for(i in metiers) {
						$("#APIMetier").append('<option value='+metiers[i].nom+'>'+metiers[i].nom+'</option>');
					}
				},
				dataType: 'json'
		});
		
	});
	
});

//var parcour;
//$.post('api/getParcour',$('#metier').text(), function(data) {
//	parcour = data;
//});
//$(document).ready(function(){
//	for(i in parcour) {
//		$("#APIParcour").append('<button class="accordion">' +parcour[i].name +'</button><div class="panel"><p>'+parcour[i].description+'</p></div>');
//	}
//});
//
//$( "#footer" ).load( "http://localhost:8080/Footer.html" );
