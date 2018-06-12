package com.Orbis.api;

import com.Orbis.model.Parcours;
import com.Orbis.model.Prerequis;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(value = "parcours", description = "API pour les parcours")
public interface ProfesseurApi {

    @ApiOperation(value = "Récupérer tout les parcours associées à un professeur", notes = "", response = Prerequis.class, tags={ "parcours", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Success", response = Prerequis.class /*type de retour*/)
    })
    @RequestMapping(value = "api/getParcoursOfConnectedProfesseur",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Parcours>> getParcoursOfConnectedProfesseur();
}