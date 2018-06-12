package com.Orbis.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;

import io.swagger.annotations.ApiParam;

@Controller
public class PrerequisApiController implements PrerequisApi{

	@Override
	public ResponseEntity<List<Prerequis>> getAllPrerequis() {
		List<Prerequis> prerequis = Prerequis.getAllPrerequis();
		return new ResponseEntity<>(prerequis, HttpStatus.OK);
	}
	
	
	
    public ResponseEntity<List<Prerequis>> getPrerequisOfParcours(@ApiParam(value = "id du parcours", required = true) @RequestBody Long id_parcours){
    	Expression expr = Expr.eq("id_parcours", id_parcours);
    	List<PrerequisParcours> l = PrerequisParcours.find.where().add(expr).findList();
    	List<Prerequis> prerequis = new ArrayList<>();
    	for (PrerequisParcours pp : l) {
    		prerequis.add(Prerequis.getPrerequisById(pp.getIdParcours()));
    	}
    	return new ResponseEntity<>(prerequis, HttpStatus.OK);
    }
	
	
	
    public ResponseEntity<Void> setPrerequisToParcours(
            @ApiParam(value = "Association d'un prerequis à un parcours", required = true)
            @RequestBody PrerequisParcours prerequisParcours
    ){
    	if (PrerequisParcours.getPrerequisParcours(prerequisParcours.getIdPrerequis(), prerequisParcours.getIdParcours()) == null)
    		prerequisParcours.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	
    public ResponseEntity<Void> removePrerequisFromParcours(
            @ApiParam(value = "Association Prerequis_parcours à supprimer", required = true)
            @RequestBody PrerequisParcours prerequisParcours
    ){
    	PrerequisParcours pp = PrerequisParcours.getPrerequisParcours(prerequisParcours.getIdPrerequis(), prerequisParcours.getIdParcours());
    	if (pp != null)
    		pp.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
