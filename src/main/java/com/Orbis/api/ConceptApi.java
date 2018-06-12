package com.Orbis.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Concept;
import com.Orbis.model.ConceptParcours;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "concept", description = "API pour les concepts")
public interface ConceptApi {

	@ApiOperation(value = "Récupérer les concepts", notes = "", response = Void.class, tags={ "concept", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getAllConcepts",
            produces = { "application/json" },
            method = RequestMethod.GET /*méthode d'accès à l'api*/)
    ResponseEntity<List<Concept>> getAllConcepts();
	
	
	
	
	
	
	@ApiOperation(value = "Récupérer les concepts d'un parcours", notes = "", response = Void.class, tags={ "concept", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getConceptsOfParcours",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Concept>> getConceptsOfParcours(
            @ApiParam(value = "id du parcours", required = true)
            @RequestBody Long id_parcours
    );
	
	
	@ApiOperation(value = "Ajouter un concept à un parcours", notes = "", response = Void.class, tags={ "concept", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/setConceptToParcours",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<Void> setConceptToParcours(
            @ApiParam(value = "Association d'un concept à un parcours", required = true)
            @RequestBody ConceptParcours conceptParcours
    );
	
	
	@ApiOperation(value = "enlever un concept d'un parcours", notes = "", response = Void.class, tags={ "concept", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/removeConceptFromParcours",
            produces = { "application/json" },
            method = RequestMethod.DELETE /*méthode d'accès à l'api*/)
    ResponseEntity<Void> removeConceptFromParcours(
            @ApiParam(value = "Association Concept_parcours à supprimer", required = true)
            @RequestBody ConceptParcours conceptParcours
    );
	
	
	
	
	
	
	
	
	
	
	
}
