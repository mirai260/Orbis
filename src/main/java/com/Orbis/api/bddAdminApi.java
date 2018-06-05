package com.Orbis.api;

import com.Orbis.model.Domaine;
import com.Orbis.model.Eleve;
import com.Orbis.model.Parcours;
import com.Orbis.model.Prerequis;
import com.Orbis.model.PrerequisParcours;
import com.Orbis.model.Template;
import io.swagger.annotations.*;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "template", description = "the template API")
public interface bddAdminApi {
    
    
    
    /*********** DOMAINE **************/
    @ApiOperation(value = "Récupérer tout les domaines", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Domaine.class)
    })
    @RequestMapping(value = "api/getAllDomaines",
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
    
    
    /************ Eleve ***************/
    @ApiOperation(value = "Récupérer tout les Eleves", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllEleves",
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
    
    
    /************* Parcours ***************/
    @ApiOperation(value = "Récupérer tout les parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllParcours",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Parcours>> getAllParcours();
    
    @ApiOperation(value = "Ajouter un Parcours", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addParcours",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addParcours(@ApiParam(value = "Eleve à ajouter" ,required=true) @RequestBody Parcours parcours);
    
    
    /************ Prerequis ****************/
    @ApiOperation(value = "Récupérer tout les prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Void.class)
    })
    @RequestMapping(value = "api/getAllPrerequis",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Prerequis>> getAllPrerequis();
    
    @ApiOperation(value = "Ajouter un Prerequis", notes = "", response = Void.class, tags={ "administration", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Ajout effectué", response = Void.class),
    })
    @RequestMapping(value = "api/addPrerequis",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addPrerequis(@ApiParam(value = "Prerequis à ajouter" ,required=true) @RequestBody Prerequis prerequis);
    
    
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
    
    
    
}