package com.Orbis.api;


import io.swagger.annotations.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Orbis.model.Admin;
import com.Orbis.model.Concept;
import com.Orbis.model.Domaine;
import com.Orbis.model.Eleve;
import com.Orbis.model.Metier;
import com.Orbis.model.Parcours;
import com.Orbis.model.Parcours_Professeur;
import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;
import com.Orbis.model.Professeur;

@Api(value = "template", description = "the template API")
public interface bddAdminApi {
    
    
    
    /*********** DOMAINE **************/
    @ApiOperation(value = "Récupérer tout les domaines", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Domaine.class)
    })
    @RequestMapping(value = "api/getAllDomaine",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Domaine>> getAllDomaines();
    
    
    @ApiOperation(value = "Ajouter un domaine", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class)
    })
    @RequestMapping(value = "api/addDomaine",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addDomaine(@ApiParam(value = "Domaine à ajouter" ,required=true) @RequestBody Domaine domaine);
    
    
    @ApiOperation(value = "Supprimer un domaine", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteDomaine",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteDomaine(@ApiParam(value = "Id du Domaine à supprimer" ,required=true) @RequestBody Long id);
    
    
    @ApiOperation(value = "Modifier un domaine", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyDomaine",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyDomaine(@ApiParam(value = "Domaine à modifier" ,required=true) @RequestBody Domaine domaine);
    
    
    
    /************ Eleve ***************/
    @ApiOperation(value = "Récupérer tout les Eleves", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllEleve",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Eleve>> getAllEleves();
    
    @ApiOperation(value = "Ajouter un Eleve", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
            
    })
    @RequestMapping(value = "api/addEleve",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addEleve(@ApiParam(value = "Eleve à ajouter" ,required=true) @RequestBody Eleve eleve);
    
    
    @ApiOperation(value = "Supprimer un Eleve", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteEleve",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEleve(@ApiParam(value = "Id de l'Eleve à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un Eleve", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyEleve",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyEleve(@ApiParam(value = "Eleve à modifier" ,required=true) @RequestBody Eleve eleve);
    
    
/************ Professeur **************/
    
    @ApiOperation(value = "Récupérer tout les Professeurs", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllProfesseur",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Professeur>> getAllProfesseur();
    
    
    @ApiOperation(value = "Ajouter un Professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addProfesseur",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addProfesseur(@ApiParam(value = "Professeur à ajouter" ,required=true) @RequestBody Professeur professeur);
    
    @ApiOperation(value = "Supprimer un Professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteProfesseur",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteProfesseur(@ApiParam(value = "Id du Professeur à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un Professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyProfesseur",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyProfesseur(@ApiParam(value = "Professeur à modifier" ,required=true) @RequestBody Professeur professeur);
    
    
    /************ Admin ***************/
    @ApiOperation(value = "Récupérer tout les Admins", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllAdmin",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Admin>> getAllAdmins();
    
    @ApiOperation(value = "Ajouter un Admin", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
            
    })
    @RequestMapping(value = "api/addAdmin",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addAdmin(@ApiParam(value = "Admin à ajouter" ,required=true) @RequestBody Admin admin);
    
    
    @ApiOperation(value = "Supprimer un Admin", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteAdmin",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAdmin(@ApiParam(value = "Id de l'Admin à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un Admin", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyAdmin",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyAdmin(@ApiParam(value = "Admin à modifier" ,required=true) @RequestBody Admin admin);
    
    
    /************* Parcours ***************/
//    @ApiOperation(value = "Récupérer tout les parcours", notes = "", response = Void.class, tags={ "administration", })
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "OK", response = Void.class)
//    })
//    @RequestMapping(value = "api/getAllParcours",
//            produces = { "application/json" },
//            method = RequestMethod.GET)
//    ResponseEntity<List<Parcours>> getAllParcours();
    
    @ApiOperation(value = "Ajouter un Parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addParcours",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addParcours(@ApiParam(value = "Eleve à ajouter" ,required=true) @RequestBody Parcours parcours);
    
    @ApiOperation(value = "Supprimer un parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteParcours",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteParcours(@ApiParam(value = "Id du parcours à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un Parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyParcours",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyParcours(@ApiParam(value = "Parcours à modifier" ,required=true) @RequestBody Parcours parcours);
    
    
    /************ Prerequis ****************/
    /*@ApiOperation(value = "Récupérer tout les prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllPrerequis",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Prerequis>> getAllPrerequis();*/
    
    @ApiOperation(value = "Ajouter un Prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addPrerequis",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addPrerequis(@ApiParam(value = "Prerequis à ajouter" ,required=true) @RequestBody Prerequis prerequis);
    
    @ApiOperation(value = "Supprimer un prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deletePrerequis",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePrerequis(@ApiParam(value = "Id du Prerequis à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un Prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyPrerequis",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyPrerequis(@ApiParam(value = "Prerequis à modifier" ,required=true) @RequestBody Prerequis prerequis);
    
    /************ Prerequis Parcours **************/
    @ApiOperation(value = "Récupérer toute les associations prérequis/parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllPrerequisParcours",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<PrerequisParcours>> getAllPrerequisParcours();
    
    
    @ApiOperation(value = "Ajouter une association Prerequis/Parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addPrerequisParcours",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addPrerequisParcours(@ApiParam(value = "Association prerequis/parcours à ajouter" ,required=true) @RequestBody PrerequisParcours prerequisParcours);
    
    @ApiOperation(value = "Supprimer un prerequisParcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deletePrerequisParcours",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deletePrerequisParcours(@ApiParam(value = "Id du prerequis_parcours à supprimer" ,required=true) @RequestBody Long id);
    
    
    /************ Concept **************/
    
    @ApiOperation(value = "Récupérer tout les concepts", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllConcept",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Concept>> getAllConcept();
    
    
    @ApiOperation(value = "Ajouter un concept", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addConcept",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addConcept(@ApiParam(value = "concept à ajouter" ,required=true) @RequestBody Concept concept);
    
    @ApiOperation(value = "Supprimer un concept", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteConcept",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteConcept(@ApiParam(value = "Id du concept à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un concept", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyConcept",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyConcept(@ApiParam(value = "Concept à modifier" ,required=true) @RequestBody Concept concept);
    
    
/************ Metier **************/
    
    @ApiOperation(value = "Récupérer tout les Métiers", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllMetier",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Metier>> getAllMetier();
    
    
    @ApiOperation(value = "Ajouter un Metier", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addMetier",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addMetier(@ApiParam(value = "metier à ajouter" ,required=true) @RequestBody Metier metier);
    
    @ApiOperation(value = "Supprimer un metier", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteMetier",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMetier(@ApiParam(value = "Id du metier à supprimer" ,required=true) @RequestBody Long id);
    
    @ApiOperation(value = "Modifier un metier", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "modification effectué", response = Void.class)
    })
    @RequestMapping(value = "api/modifyMetier",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> modifyMetier(@ApiParam(value = "Metier à modifier" ,required=true) @RequestBody Metier metier);
    
    
/************ Parcours_Professeurs **************/
    
    @ApiOperation(value = "Récupérer tout les Parcours_professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllParcours_Professeur",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Parcours_Professeur>> getAllParcours_Professeur();
    
    
    @ApiOperation(value = "Ajouter un Parcours_Professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addParcours_Professeur",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addParcours_Professeur(@ApiParam(value = "Parcours_Professeur à ajouter" ,required=true) @RequestBody Parcours_Professeur parcours_professeur);
    
    @ApiOperation(value = "Supprimer un Parcours_Professeur", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Supression effectué", response = Void.class)
    })
    @RequestMapping(value = "api/deleteParcours_Professeur",
            produces = { "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteParcours_Professeur(@ApiParam(value = "Id du Parcours_Professeur à supprimer" ,required=true) @RequestBody Long id);
    
    
    
    
    
    
    
    
    
    
    @ApiOperation(value = "Connaitre son role", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = Void.class)
    })
    @RequestMapping(value = "api/getMyRole",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<GrantedAuthority> getMyRole();
    
}