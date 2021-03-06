package com.Orbis.api;

import com.Orbis.model.Parcours;
import com.Orbis.model.ParcoursMatched;
import com.Orbis.model.Prerequis;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(value = "parcours", description = "API pour les parcours")
public interface ParcoursApi {

	@ApiOperation(value = "Récupérer les parcours liés à ces métiers", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Métier non trouvé", response = Void.class /*type de retour*/)
    })
    
    @RequestMapping(value = "api/getAllParcours",
            produces = { "application/json" },
            method = RequestMethod.GET /*méthode d'accès à l'api*/)
    ResponseEntity<List<Parcours>/*type de retour*/> getAllParcours();
	
    @ApiOperation(value = "Récupérer les parcours possédant ces prérequis", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Prérequis non trouvé", response = Void.class /*type de retour*/)
    })
    
    @RequestMapping(value = "api/getParcoursWithPrerequis",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Parcours>/*type de retour*/> getParcoursWithPrerequis(
            @ApiParam(value = "liste des ids des prérequis", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listePrerequis    //Paramètre passé en POST (données de formulaire)
    );
    
    @ApiOperation(value = "Récupérer les parcours liés à ces métiers", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Métier non trouvé", response = Void.class /*type de retour*/)
    })
    
    @RequestMapping(value = "api/getParcoursByMetiers",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Parcours>/*type de retour*/> getParcoursByMetiers(
            @ApiParam(value = "liste des ids des métiers", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listeMetiers    //Paramètre passé en POST (données de formulaire)
    );

    @ApiOperation(value = "Récupérer les parcours liés à ces métiers", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Métier non trouvé", response = Void.class /*type de retour*/)
    })
    
    @RequestMapping(value = "api/getParcoursByConcepts",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Parcours>/*type de retour*/> getParcoursByConcepts(
            @ApiParam(value = "liste des ids des concepts", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listeConcepts    //Paramètre passé en POST (données de formulaire)
    );
    
    @ApiOperation(value = "Récupérer les parcours liés à ces métiers", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Métier non trouvé", response = Void.class /*type de retour*/)
    })
    
    @RequestMapping(value = "api/sortParcours",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<ParcoursMatched>> sortParcours(
            @ApiParam(value = "liste des ids des métiers", required = true)
            @RequestBody List<Parcours>/*type de paramètre*/ listeParcoursMatched    //Paramètre passé en POST (données de formulaire)
    );
}