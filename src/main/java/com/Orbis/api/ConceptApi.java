package com.Orbis.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Concept;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Concept>> getAllConcepts();
}
