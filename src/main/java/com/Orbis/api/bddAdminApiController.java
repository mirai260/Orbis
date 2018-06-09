package com.Orbis.api;

import com.Orbis.model.Domaine;
import com.Orbis.model.Eleve;
import com.Orbis.model.Parcours;
import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;

import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


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
    
    public ResponseEntity<Void> deleteDomaine(@ApiParam(value = "Id du Domaine à supprimer" ,required=true) @RequestBody long id){
    	Domaine domaine = Domaine.getDomaineById(id);
    	domaine.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyDomaine(@ApiParam(value = "Domaine à modifier" ,required=true) @RequestBody Domaine domaine){
    	Domaine oldDomaine = Domaine.getDomaineById(domaine.getId_domaine());
    	oldDomaine.delete();
    	domaine.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Eleve ***************/
    public ResponseEntity<List<Eleve>> getAllEleves(){
    	return new ResponseEntity<>(Eleve.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addEleve(@ApiParam(value = "Eleve à ajouter" ,required=true) @RequestBody Eleve eleve){
    	System.out.println("test");
    	System.out.println(eleve.getId_eleve() + " " + eleve.getLogin() + " " + eleve.getMdp());
    	//eleve.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteEleve(@ApiParam(value = "Id de l'Eleve à supprimer" ,required=true) @RequestBody long id){
    	Eleve eleve = Eleve.getEleveById(id);
    	eleve.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyEleve(@ApiParam(value = "Eleve à modifier" ,required=true) @RequestBody Eleve eleve){
    	Eleve oldEleve = Eleve.getEleveById(eleve.getId_eleve());
    	oldEleve.delete();
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
    
    public ResponseEntity<Void> deleteParcours(@ApiParam(value = "Id du parcours à supprimer" ,required=true) @RequestBody long id){
    	Parcours parcours = Parcours.getParcoursById(id);
    	parcours.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyParcours(@ApiParam(value = "Parcours à modifier" ,required=true) @RequestBody Parcours parcours){
    	Parcours oldParcours = Parcours.getParcoursById(parcours.getId_parcours());
    	oldParcours.delete();
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
    
    public ResponseEntity<Void> deletePrerequis(@ApiParam(value = "Id du prerequis à supprimer" ,required=true) @RequestBody long id){
    	Prerequis prerequis = Prerequis.getPrerequisById(id);
    	prerequis.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyPrerequis(@ApiParam(value = "Parcours à modifier" ,required=true) @RequestBody Prerequis prerequis){
    	Prerequis oldPrerequis = Prerequis.getPrerequisById(prerequis.getId_prerequis());
    	oldPrerequis.delete();
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
    
    public ResponseEntity<Void> deletePrerequisParcours(@ApiParam(value = "Id du prerequisParcours à supprimer" ,required=true) @RequestBody long id){
    	PrerequisParcours prerequisParcours = PrerequisParcours.getPrerequisParcoursById(id);
    	prerequisParcours.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }

}
