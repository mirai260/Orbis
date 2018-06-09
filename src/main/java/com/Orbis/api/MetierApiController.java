package com.Orbis.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.Orbis.model.Metier;

import io.swagger.annotations.ApiParam;

@Controller
public class MetierApiController implements MetierApi {

	@Override
	public ResponseEntity<List<Metier>> getMetierByDomaine(
			@ApiParam(value = "Nom du domaine" ,required=true )
			@RequestBody String/*type de paramètre*/ domaine    //Paramètre passé en POST (données de formulaire)
    ){
		System.out.println(domaine.substring(8));
		List<Metier> metiers = Metier.getMetierByDomaine(domaine.substring(8));
        return new ResponseEntity<>(metiers, HttpStatus.OK);
	}

}
