package com.Orbis.model;


import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PrerequisParcours extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_prerequis_parcours;

    private Long idPrerequis;
    private Long idParcours;


    public static Model.Find<Long, PrerequisParcours> find = new Model.Find<Long, PrerequisParcours>() {};  // Outil de recherche dans la bdd

    public static PrerequisParcours getPrerequisParcoursById(Long id_prerequis_parcours){
		Expression expr = Expr.eq("id_prerequis_parcours", id_prerequis_parcours);
		return find.where().add(expr).findUnique();
	}

    public Long getId_prerequis_parcours() {
        return id_prerequis_parcours;
    }

    public void setId_prerequis_parcours(Long id_prerequis_parcours) {
        this.id_prerequis_parcours = id_prerequis_parcours;
    }

    public Long getIdPrerequis() {
        return idPrerequis;
    }

    public void setIdPrerequis(Long idPrerequis) {
        this.idPrerequis = idPrerequis;
    }

    public Long getIdParcours() {
        return idParcours;
    }

    public void setIdParcours(Long idParcours) {
        this.idParcours = idParcours;
    }
}