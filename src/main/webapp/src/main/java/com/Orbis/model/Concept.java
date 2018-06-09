package com.Orbis.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Concept {

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long idConcept;
	
	private String nom;
	
	public static Model.Find<Long, Concept> find = new Model.Find<Long, Concept>() {};
	
	public static List<Concept> getAllConcepts(){
        return find.all();
    }
	
	public Long getIdConcept() {
        return idConcept;
    }

    public void setIdConcept(Long idConcept) {
        this.idConcept = idConcept;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}