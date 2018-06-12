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
    
    public static ConceptParcours getConceptParcours(Long id_concept, Long id_parcours){
		Expression expr1 = Expr.eq("id_parcours", id_parcours);
		Expression expr2 = Expr.eq("id_concept", id_concept);
		return find.where().add(expr1).add(expr2).findUnique();
	}

    public Long getId_concept_parcours() {
        return id_concept_parcours;
    }

    public void setId_concept_parcours(Long id_concept_parcours) {
        this.id_concept_parcours = id_concept_parcours;
    }

	public Long getId_concept() {
		return id_concept;
	}

	public void setId_concept(Long id_concept) {
		this.id_concept = id_concept;
	}

	public Long getId_parcours() {
		return id_parcours;
	}

	public void setId_parcours(Long id_parcours) {
		this.id_parcours = id_parcours;
	}

    
}