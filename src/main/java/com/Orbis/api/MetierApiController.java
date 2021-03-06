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
	public ResponseEntity<List<Metier>> getMetiersByDomaine(
			@ApiParam(value = "Nom du domaine" ,required=true )
			@RequestBody String domaine
    ){
//		System.out.println(domaine);
		List<Metier> metiers = Metier.getMetierByDomaine(domaine);
        return new ResponseEntity<>(metiers, HttpStatus.OK);
	}

}
