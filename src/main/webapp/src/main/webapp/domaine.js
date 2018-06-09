$(document).ready(function(){
	$('#domaine').change(function(){
		if($('#fromMetier')){
			$('#fromMetier').remove();
		}
		switch($(this).val()) {
	    case "info":
	        $(this).after('<form id="fromMetier"><div><input type="radio" name="metier" value="ing" checked> Ingénieur Informatique<br><input type="radio" name="metier" value="cho"> Chômageur Informatique<br><input type="radio" name="metier" value="sta"> Stagiaire Informatique<br></div><div><input type="submit"></div></form>');
	        break;
	    case "res":
	    	$(this).after('<form id="fromMetier"><div><input type="radio" name="metier" value="ing" checked> Ingénieur Réseaux<br><input type="radio" name="metier" value="cho"> Chômageur Réseaux<br><input type="radio" name="metier" value="sta"> Stagiaire Réseaux<br></div><div><input type="submit"></div></form>');
	        break;
	    case "sysemb":
	    	$(this).after('<form id="fromMetier"><div><input type="radio" name="metier" value="ing" checked> Ingénieur System Embarque<br><input type="radio" name="metier" value="cho"> Chômageur System Embarque<br><input type="radio" name="metier" value="sta"> Stagiaire System Embarque<br></div><div><input type="submit"></div></form>');
	        break;
	    case "elc":
	    	$(this).after('<form id="fromMetier"><div><input type="radio" name="metier" value="ing" checked> Ingénieur Électronique<br><input type="radio" name="metier" value="cho"> Chômageur Électronique<br><input type="radio" name="metier" value="sta"> Stagiaire Électronique<br></div><div><input type="submit"></div></form>');
	        break;
	    default:
	    	$(this).after('<form id="fromMetier"><div><input type="radio" name="metier" value="ing" checked> Ingénieur Informatique<br><input type="radio" name="metier" value="cho"> Chômageur Informatique<br><input type="radio" name="metier" value="sta"> Stagiaire Informatique<br></div><div><input type="submit"></div></form>');
	}

	});	

});