package com.Orbis.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Professeur {

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long idProfesseur;
	
	private String login;
	private String mdp;
	
	public static Model.Find<Long, Professeur> find = new Model.Find<Long, Professeur>() {};
	
	public Long getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Long idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}