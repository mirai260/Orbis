package com.Orbis.model;


import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConceptParcours extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_concept_parcours;

    private Long id_concept;
    private Long id_parcours;


    public static Model.Find<Long, ConceptParcours> find = new Model.Find<Long, ConceptParcours>() {};  // Outil de recherche dans la bdd

    public static ConceptParcours getConceptParcoursById(Long id_concept_parcours){
		Expression expr = Expr.eq("id_concept_parcours", id_concept_parcours);
		return find.where().add(expr).findUnique();
	}

    public Long getId_concept_parcours() {
        return id_concept_parcours;
    }

    public void setId_concept_parcours(Long id_concept_parcours) {
        this.id_concept_parcours = id_concept_parcours;
    }

    public Long getIdConcept() {
        return id_concept;
    }

    public void setIdConcept(Long id_concept) {
        this.id_concept = id_concept;
    }

    public Long getIdParcours() {
        return id_parcours;
    }

    public void setIdParcours(Long idParcours) {
        this.id_parcours = idParcours;
    }
}