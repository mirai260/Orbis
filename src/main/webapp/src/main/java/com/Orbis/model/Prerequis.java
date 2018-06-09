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
public class Prerequis extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_prerequis;

    private String nom;
    private String description;
    private String niveau;
    private String note;

    
    
    public static Model.Find<Long, Prerequis> find = new Model.Find<Long, Prerequis>() {};  // Outil de recherche dans la bdd

    
  public static Prerequis getPrerequisById(Long id_prerequis){
		Expression expr = Expr.eq("id_prerequis", id_prerequis);
		return find.where().add(expr).findUnique();
	}


	public Long getId_prerequis() {
		return id_prerequis;
	}



	public void setId_prerequis(Long id_prerequis) {
		this.id_prerequis = id_prerequis;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}


  public static List<Prerequis> getAllPrerequis() {
    return find.all();
  }

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getNiveau() {
		return niveau;
	}



	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}
    
    
    
    
}