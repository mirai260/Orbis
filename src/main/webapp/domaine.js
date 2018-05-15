$(document).ready(function(){
	$('#domaine').change(function(){
		if($('#fromMetier')){
			$('#fromMetier').remove();
		}
		switch($(this).val()) {
	    case "info":
	        $(this).after('<form id="fromMetier"><input type="radio" name="metier" value="ing" checked> Ingénieur Informatique<br><input type="radio" name="metier" value="cho"> Chômageur Informatique<br><input type="radio" name="metier" value="sta"> Stagiaire Informatique<br><input type="submit"></form>');
	        break;
	    case "res":
	    	$(this).after('<form id="fromMetier"><input type="radio" name="metier" value="ing" checked> Ingénieur Réseaux<br><input type="radio" name="metier" value="cho"> Chômageur Réseaux<br><input type="radio" name="metier" value="sta"> Stagiaire Réseaux<br><input type="submit"></form>');
	        break;
	    case "sysemb":
	    	$(this).after('<form id="fromMetier"><input type="radio" name="metier" value="ing" checked> Ingénieur System Embarque<br><input type="radio" name="metier" value="cho"> Chômageur System Embarque<br><input type="radio" name="metier" value="sta"> Stagiaire System Embarque<br><input type="submit"></form>');
	        break;
	    case "elc":
	    	$(this).after('<form id="fromMetier"><input type="radio" name="metier" value="ing" checked> Ingénieur Électronique<br><input type="radio" name="metier" value="cho"> Chômageur Électronique<br><input type="radio" name="metier" value="sta"> Stagiaire Électronique<br><input type="submit"></form>');
	        break;
	    default:
	    	$(this).after('<form id="fromMetier"><input type="radio" name="metier" value="ing" checked> Ingénieur Informatique<br><input type="radio" name="metier" value="cho"> Chômageur Informatique<br><input type="radio" name="metier" value="sta"> Stagiaire Informatique<br><input type="submit"></form>');
	}

	});	

});