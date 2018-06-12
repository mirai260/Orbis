package com.Orbis.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;

@Entity
public class Concept extends Model{

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_concept;
	
	private String nom;
	
	public void edit(Concept c) {
		this.nom = c.nom;
	}
	
	public static Model.Find<Long, Concept> find = new Model.Find<Long, Concept>() {};
	
	
	public static Concept getConceptById(Long id) {
		Expression expr = Expr.eq("id_concept", id);
		return find.where().add(expr).findUnique();
	}
	
	
	public static List<Concept> getAllConcepts(){
        return find.all();
    }
	
	

    public Long getId_concept() {
		return id_concept;
	}


	public void setId_concept(Long id_concept) {
		this.id_concept = id_concept;
	}


	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}