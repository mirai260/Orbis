package com.Orbis.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;

@Entity
public class Metier extends Model{

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_metier;
	
	private String nom;
	private String description;
	
	public static Model.Find<Long, Metier> find = new Model.Find<Long, Metier>() {};
	
	public static List<Metier> getMetierByDomaine(String domaine){
		List<Metier> metiers = new ArrayList<>();
		Long idDomaine = Domaine.getIdDomaineByName(domaine);
		List<Long> idsMetier = MetierDomaine.getIdMetierByDomaine(idDomaine);
		for(Long id : idsMetier) {
			metiers.add(getMetierById(id));
		}
        return metiers;
    }
	
	public static Metier getMetierById(Long id){
		Expression e1 = Expr.eq("id_metier", id);
        return find.where().add(e1).findUnique();
    }
	
	

    public Long getId_metier() {
		return id_metier;
	}

	public void setId_metier(Long id_metier) {
		this.id_metier = id_metier;
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