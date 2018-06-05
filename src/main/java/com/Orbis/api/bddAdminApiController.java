package com.Orbis.api;

import com.Orbis.model.Domaine;
import com.Orbis.model.Eleve;
import com.Orbis.model.Parcours;
import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;
import com.Orbis.model.Template;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class bddAdminApiController implements bddAdminApi{


	
	/*********** DOMAINE **************/
    public ResponseEntity<List<Domaine>> getAllDomaines(){
    	return new ResponseEntity<>(Domaine.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addDomaine(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Domaine domaine){
    	domaine.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Eleve ***************/
    public ResponseEntity<List<Eleve>> getAllEleves(){
    	return new ResponseEntity<>(Eleve.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addEleve(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Eleve eleve){
    	eleve.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************* Parcours ***************/
    public ResponseEntity<List<Parcours>> getAllParcours(){
    	return new ResponseEntity<>(Parcours.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addParcours(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Parcours parcours){
    	parcours.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Prerequis ****************/
    public ResponseEntity<List<Prerequis>> getAllPrerequis(){
    	return new ResponseEntity<>(Prerequis.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addPrerequis(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Prerequis prerequis){
    	prerequis.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Prerequis Parcours **************/
    public ResponseEntity<List<PrerequisParcours>> getAllPrerequisParcours(){
    	return new ResponseEntity<>(PrerequisParcours.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addPrerequisParcours(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody PrerequisParcours prerequisParcours){
    	prerequisParcours.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
