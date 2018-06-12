package com.Orbis.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.Orbis.model.Concept;
import com.Orbis.model.ConceptParcours;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;

import io.swagger.annotations.ApiParam;

@Controller
public class ConceptApiController implements ConceptApi {

	@Override
	public ResponseEntity<List<Concept>> getAllConcepts() {
		List<Concept> concepts = Concept.getAllConcepts();
		return new ResponseEntity<>(concepts, HttpStatus.OK);
	}
	
	
	
	
	
	
	public ResponseEntity<List<Concept>> getConceptsOfParcours(@ApiParam(value = "id du parcours", required = true) @RequestBody Long id_parcours){
    	Expression expr = Expr.eq("id_parcours", id_parcours);
    	List<ConceptParcours> l = ConceptParcours.find.where().add(expr).findList();
    	List<Concept> concepts = new ArrayList<>();
    	for (ConceptParcours cp : l) {
    		concepts.add(Concept.getConceptById(cp.getIdConcept()));
    	}
    	return new ResponseEntity<>(concepts, HttpStatus.OK);
    }
	
	
	
    public ResponseEntity<Void> setConceptToParcours(
            @ApiParam(value = "Association d'un concept à un parcours", required = true)
            @RequestBody ConceptParcours conceptParcours
    ){
    	if (ConceptParcours.getConceptParcours(conceptParcours.getIdConcept(), conceptParcours.getIdParcours()) == null)
    		conceptParcours.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
	
	
	
    public ResponseEntity<Void> removeConceptFromParcours(
            @ApiParam(value = "Association Concept_parcours à supprimer", required = true)
            @RequestBody ConceptParcours conceptParcours
    ){
    	ConceptParcours cp = ConceptParcours.getConceptParcours(conceptParcours.getIdConcept(), conceptParcours.getIdParcours());
    	if (cp != null)
    		cp.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
