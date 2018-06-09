package com.Orbis.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Prerequis;

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
}
