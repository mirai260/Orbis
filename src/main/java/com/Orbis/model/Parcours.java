package com.Orbis.model;


import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parcours extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_parcours;

    private String nom;
    private String description;



    public static Model.Find<Long, Parcours> find = new Model.Find<Long, Parcours>() {};  // Outil de recherche dans la bdd

    public static Parcours getParcoursById(Long id_parcours){
		Expression expr = Expr.eq("id_parcours", id_parcours);
		return find.where().add(expr).findUnique();
	}

	public Long getId_parcours() {
		return id_parcours;
	}
	public void setId_parcours(Long id_parcours) {
		this.id_parcours = id_parcours;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}