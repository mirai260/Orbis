package com.Orbis.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Domaine;
import com.Orbis.model.Metier;
import com.Orbis.model.Template;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "metier", description = "API pour les métiers")
public interface MetierApi {

	@ApiOperation(value = "Récupérer les métiers", notes = "", response = Void.class, tags={ "metier", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Échec", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getMetiersByDomaine",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<List<Metier>/*type de retour*/> getMetierByDomaine(
    		 @ApiParam(value = "Nom du domaine" ,required=true )
             @RequestBody String/*type de paramètre*/ domaine    //Paramètre passé en POST (données de formulaire)
             );
}
