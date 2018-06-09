package com.Orbis.model;


import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MetierParcours extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_metier_parcours;

    private Long id_metier;
    private Long id_parcours;


    public static Model.Find<Long, MetierParcours> find = new Model.Find<Long, MetierParcours>() {};  // Outil de recherche dans la bdd

    public static MetierParcours getMetiersParcoursById(Long id_metier_parcours){
		Expression expr = Expr.eq("id_metier_parcours", id_metier_parcours);
		return find.where().add(expr).findUnique();
	}

    public Long getId_metier_parcours() {
        return id_metier_parcours;
    }

    public void setId_metier_parcours(Long id_metier_parcours) {
        this.id_metier_parcours = id_metier_parcours;
    }

    public Long getIdMetier() {
        return id_metier;
    }

    public void setIdMetier(Long id_metier) {
        this.id_metier = id_metier;
    }

    public Long getIdParcours() {
        return id_parcours;
    }

    public void setIdParcours(Long idParcours) {
        this.id_parcours = idParcours;
    }
}