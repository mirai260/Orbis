package com.Orbis.api;

import com.Orbis.model.Admin;
import com.Orbis.model.Concept;
import com.Orbis.model.Domaine;
import com.Orbis.model.Eleve;
import com.Orbis.model.Metier;
import com.Orbis.model.Parcours;
import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;
import com.Orbis.model.Professeur;

import io.swagger.annotations.ApiParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
    
    public ResponseEntity<Void> deleteDomaine(@ApiParam(value = "Id du Domaine à supprimer" ,required=true) @RequestBody Long id){
    	Domaine domaine = Domaine.getDomaineById(id);
    	domaine.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyDomaine(@ApiParam(value = "Domaine à modifier" ,required=true) @RequestBody Domaine domaine){
    	Domaine oldDomaine = Domaine.getDomaineById(domaine.getId_domaine());
    	oldDomaine.edit(domaine);
    	oldDomaine.save();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Eleve ***************/
    public ResponseEntity<List<Eleve>> getAllEleves(){
    	return new ResponseEntity<>(Eleve.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addEleve(@ApiParam(value = "Eleve à ajouter" ,required=true) @RequestBody Eleve eleve){
    	eleve.setMdp(BCrypt.hashpw(eleve.getMdp(), BCrypt.gensalt()));
    	eleve.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteEleve(@ApiParam(value = "Id de l'Eleve à supprimer" ,required=true) @RequestBody Long id){
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
    
    
    /************ Professeur ***************/
    public ResponseEntity<List<Professeur>> getAllProfesseur(){
    	return new ResponseEntity<>(Professeur.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addProfesseur(@ApiParam(value = "Professeur à ajouter" ,required=true) @RequestBody Professeur professeur){
    	professeur.setMdp(BCrypt.hashpw(professeur.getMdp(), BCrypt.gensalt()));
    	professeur.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteProfesseur(@ApiParam(value = "Id du Professeur à supprimer" ,required=true) @RequestBody Long id){
    	Professeur professeur = Professeur.getProfesseurById(id);
    	professeur.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyProfesseur(@ApiParam(value = "Professeur à modifier" ,required=true) @RequestBody Professeur professeur){
    	Professeur oldProfesseur = Professeur.getProfesseurById(professeur.getId_professeur());
    	oldProfesseur.delete();
    	professeur.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Admin ***************/
    public ResponseEntity<List<Admin>> getAllAdmins(){
    	return new ResponseEntity<>(Admin.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addAdmin(@ApiParam(value = "Admin à ajouter" ,required=true) @RequestBody Admin admin){
    	admin.setMdp(BCrypt.hashpw(admin.getMdp(), BCrypt.gensalt()));
    	admin.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteAdmin(@ApiParam(value = "Id de l'Admin à supprimer" ,required=true) @RequestBody Long id){
    	Admin admin = Admin.getAdminById(id);
    	admin.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyAdmin(@ApiParam(value = "Admin à modifier" ,required=true) @RequestBody Admin admin){
    	Admin oldAdmin = Admin.getAdminById(admin.getId_admin());
    	oldAdmin.delete();
    	admin.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************* Parcours ***************/
//    public ResponseEntity<List<Parcours>> getAllParcours(){
//    	return new ResponseEntity<>(Parcours.find.all(), HttpStatus.OK);
//    }
    
    public ResponseEntity<Void> addParcours(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Parcours parcours){
    	parcours.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteParcours(@ApiParam(value = "Id du parcours à supprimer" ,required=true) @RequestBody Long id){
    	Parcours parcours = Parcours.getParcoursById(id);
    	parcours.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyParcours(@ApiParam(value = "Parcours à modifier" ,required=true) @RequestBody Parcours parcours){
    	Parcours oldParcours = Parcours.getParcoursById(parcours.getId_parcours());
    	oldParcours.edit(parcours);
    	oldParcours.save();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /************ Prerequis ****************/
    /*public ResponseEntity<List<Prerequis>> getAllPrerequis(){
    	return new ResponseEntity<>(Prerequis.find.all(), HttpStatus.OK);
    }*/
    
    public ResponseEntity<Void> addPrerequis(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Prerequis prerequis){
    	prerequis.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deletePrerequis(@ApiParam(value = "Id du prerequis à supprimer" ,required=true) @RequestBody Long id){
    	Prerequis prerequis = Prerequis.getPrerequisById(id);
    	prerequis.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyPrerequis(@ApiParam(value = "Parcours à modifier" ,required=true) @RequestBody Prerequis prerequis){
    	Prerequis oldPrerequis = Prerequis.getPrerequisById(prerequis.getId_prerequis());
    	oldPrerequis.edit(prerequis);
    	oldPrerequis.save();
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
    
    public ResponseEntity<Void> deletePrerequisParcours(@ApiParam(value = "Id du prerequisParcours à supprimer" ,required=true) @RequestBody Long id){
    	PrerequisParcours prerequisParcours = PrerequisParcours.getPrerequisParcoursById(id);
    	prerequisParcours.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /************* Concepts ***************/
    public ResponseEntity<List<Concept>> getAllConcept(){
    	return new ResponseEntity<>(Concept.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addConcept(@ApiParam(value = "Concept à ajouter" ,required=true) @RequestBody Concept concept){
    	concept.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteConcept(@ApiParam(value = "Id du concept à supprimer" ,required=true) @RequestBody Long id){
    	Concept concept = Concept.getConceptById(id);
    	concept.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyConcept(@ApiParam(value = "Concept à modifier" ,required=true) @RequestBody Concept concept){
    	Concept oldConcept = Concept.getConceptById(concept.getId_concept());
    	oldConcept.edit(concept);
    	oldConcept.save();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /************* Metier ***************/
    public ResponseEntity<List<Metier>> getAllMetier(){
    	return new ResponseEntity<>(Metier.find.all(), HttpStatus.OK);
    }
    
    public ResponseEntity<Void> addMetier(@ApiParam(value = "Metier à ajouter" ,required=true) @RequestBody Metier metier){
    	metier.insert();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteMetier(@ApiParam(value = "Id du metier à supprimer" ,required=true) @RequestBody Long id){
    	Metier metier = Metier.getMetierById(id);
    	metier.delete();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    public ResponseEntity<Void> modifyMetier(@ApiParam(value = "Metier à modifier" ,required=true) @RequestBody Metier metier){
    	Metier oldMetier = Metier.getMetierById(metier.getId_metier());
    	oldMetier.edit(metier);
    	oldMetier.save();
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    /************************************************************************
     * 
     * *********************************************************************/
    
    
    public ResponseEntity<GrantedAuthority> getMyRole(){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	GrantedAuthority role = (GrantedAuthority)authentication.getAuthorities().toArray()[0];
    	return new ResponseEntity<>(role, HttpStatus.OK);
    }

}
