package com.Orbis.api;

import com.Orbis.model.Parcours;
import com.Orbis.model.PrerequisParcours;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ParcoursApiController implements ParcoursApi{


    @Override
    public ResponseEntity<List<Parcours>/*type de retour*/> getParcoursWithPrerequis(
            @ApiParam(value = "liste de prérequis", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listePrerequis    //Paramètre passé en POST (données de formulaire)
    ){
        List<Parcours> parcours = Parcours.find.where()
                .notIn(
                    "idParcours",
                    PrerequisParcours.find.select("idParcours").where()
                            .notIn(
                                    "idPrerequis",
                                    listePrerequis)
                            .setDistinct(true))
                .findList();
        return new ResponseEntity<>(parcours, HttpStatus.OK);
    }

}
