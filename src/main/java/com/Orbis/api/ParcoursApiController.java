package com.Orbis.api;

import com.Orbis.model.ConceptParcours;
import com.Orbis.model.MetierParcours;
import com.Orbis.model.Parcours;
import com.Orbis.model.ParcoursMatched;
import com.Orbis.model.PrerequisParcours;

import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParcoursApiController implements ParcoursApi{

    @Override
    public ResponseEntity<List<Parcours>/*type de retour*/> getParcoursWithPrerequis(
            @ApiParam(value = "liste de prérequis", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listePrerequis    //Paramètre passé en POST (données de formulaire)
    ){
        List<Parcours> parcours = Parcours.find.where()
                .in(
                    "id_parcours",
                    PrerequisParcours.find.select("id_parcours").where()
                            .in(
                                    "id_prerequis",
                                    listePrerequis)
                            .setDistinct(true))
                .findList();
        return new ResponseEntity<>(parcours, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<List<Parcours>/*type de retour*/> getParcoursByMetiers(
            @ApiParam(value = "liste des ids des métiers", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listeMetiers    //Paramètre passé en POST (données de formulaire)
    ){
		List<Parcours> parcours = Parcours.find.where()
              .in(
                  "id_parcours",
                  MetierParcours.find.select("id_parcours").where()
                          .in(
                                  "id_metier",
                                  listeMetiers)
                          .setDistinct(true))
              .findList();
      return new ResponseEntity<>(parcours, HttpStatus.OK);
    }
	
	@Override
	public ResponseEntity<List<Parcours>/*type de retour*/> getParcoursByConcepts(
            @ApiParam(value = "liste des ids des concepts", required = true)
            @RequestBody List<Long>/*type de paramètre*/ listeConcepts    //Paramètre passé en POST (données de formulaire)
    ){
        List<Parcours> parcours = Parcours.find.where()
                .in(
                    "id_parcours",
                    ConceptParcours.find.select("id_parcours").where()
                            .in(
                                    "id_concept",
                                    listeConcepts)
                            .setDistinct(true))
                .findList();
        return new ResponseEntity<>(parcours, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<List<ParcoursMatched>> sortParcours(
			@ApiParam(value = "liste de parcours qui correspondent à la recherche", required = true)
			@RequestBody List<Parcours> listeParcoursMatched
	) {
		List<ParcoursMatched> res = new ArrayList<>();
		List<Parcours> parcours = inClass_getAllParcours();
		for(Parcours p : parcours) {
			if(listeParcoursMatched.contains(p)) {
				ParcoursMatched pMatched = new ParcoursMatched(p, true);
				res.add(0, pMatched);
			}
			else {
				ParcoursMatched pMatched = new ParcoursMatched(p, false);
				res.add(pMatched);
			}
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<Parcours>> getAllParcours() {
		return new ResponseEntity<>(Parcours.find.all(), HttpStatus.OK);
	}
	
	public List<Parcours> inClass_getAllParcours() {
		return Parcours.find.all();
	}
}
