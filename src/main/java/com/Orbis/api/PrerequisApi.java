package com.Orbis.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "prerequis", description = "API pour les prérequis")
public interface PrerequisApi {

	@ApiOperation(value = "Récupérer les prérequis", notes = "", response = Void.class, tags={ "prérequis", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getAllPrerequis",
            produces = { "application/json" },
            method = RequestMethod.GET /*méthode d'accès à l'api*/)
    ResponseEntity<List<Prerequis>/*type de retour*/> getAllPrerequis();
	
	

    
    
	@ApiOperation(value = "Récupérer les prérequis d'un parcours", notes = "", response = Void.class, tags={ "prérequis", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getPrerequisOfParcours",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Prerequis>> getPrerequisOfParcours(
            @ApiParam(value = "id du parcours", required = true)
            @RequestBody Long id_parcours
    );
	
	
	@ApiOperation(value = "Ajouter un prérequis à un parcours", notes = "", response = Void.class, tags={ "prérequis", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/setPrerequisToParcours",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<Void> setPrerequisToParcours(
            @ApiParam(value = "Association d'un prerequis à un parcours", required = true)
            @RequestBody PrerequisParcours prerequisParcours
    );
	
	
	@ApiOperation(value = "enlever un prérequis d'un parcours", notes = "", response = Void.class, tags={ "prérequis", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/removePrerequisFromParcours",
            produces = { "application/json" },
            method = RequestMethod.DELETE /*méthode d'accès à l'api*/)
    ResponseEntity<Void> removePrerequisFromParcours(
            @ApiParam(value = "Association Prerequis_parcours à supprimer", required = true)
            @RequestBody PrerequisParcours prerequisParcours
    );
    
    
}
