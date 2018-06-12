package com.Orbis.model;


import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parcours_Professeur extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_parcours_professeur;

    private Long id_parcours;
    private Long id_professeur;


    public static Model.Find<Long, Parcours_Professeur> find = new Model.Find<Long, Parcours_Professeur>() {};  // Outil de recherche dans la bdd

    
    
    public static Parcours_Professeur getMetiersParcoursById(Long id_metier_parcours){
		Expression expr = Expr.eq("id_metier_parcours", id_metier_parcours);
		return find.where().add(expr).findUnique();
	}

	public Long getId_parcours_professeur() {
		return id_parcours_professeur;
	}

	public void setId_parcours_professeur(Long id_parcours_professeur) {
		this.id_parcours_professeur = id_parcours_professeur;
	}

	public Long getId_parcours() {
		return id_parcours;
	}

	public void setId_parcours(Long id_parcours) {
		this.id_parcours = id_parcours;
	}

	public Long getId_professeur() {
		return id_professeur;
	}

	public void setId_professeur(Long id_professeur) {
		this.id_professeur = id_professeur;
	}

    
    
}