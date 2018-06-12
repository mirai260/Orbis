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

    private Long id_prerequis;
    private Long id_parcours;


    public static Model.Find<Long, PrerequisParcours> find = new Model.Find<Long, PrerequisParcours>() {};  // Outil de recherche dans la bdd

    public static PrerequisParcours getPrerequisParcoursById(Long id_prerequis_parcours){
		Expression expr = Expr.eq("id_prerequis_parcours", id_prerequis_parcours);
		return find.where().add(expr).findUnique();
	}
    
    public static PrerequisParcours getPrerequisParcours(Long id_prerequis, Long id_parcours){
		Expression expr1 = Expr.eq("id_prerequis", id_prerequis);
		Expression expr2 = Expr.eq("id_parcours", id_parcours);
		return find.where().add(expr1).add(expr2).findUnique();
	}

    public Long getId_prerequis_parcours() {
        return id_prerequis_parcours;
    }

    public void setId_prerequis_parcours(Long id_prerequis_parcours) {
        this.id_prerequis_parcours = id_prerequis_parcours;
    }

	public Long getId_prerequis() {
		return id_prerequis;
	}

	public void setId_prerequis(Long id_prerequis) {
		this.id_prerequis = id_prerequis;
	}

	public Long getId_parcours() {
		return id_parcours;
	}

	public void setId_parcours(Long id_parcours) {
		this.id_parcours = id_parcours;
	}

    
}