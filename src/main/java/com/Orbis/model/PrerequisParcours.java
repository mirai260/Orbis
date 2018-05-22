package com.Orbis.model;


import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PrerequisParcours {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long idPrerequisParcours;

    private Long idPrerequis;
    private Long idParcours;


    public static Model.Find<Long, PrerequisParcours> find = new Model.Find<Long, PrerequisParcours>() {};  // Outil de recherche dans la bdd


    public Long getIdPrerequisParcours() {
        return idPrerequisParcours;
    }

    public void setIdPrerequisParcours(Long idPrerequisParcours) {
        this.idPrerequisParcours = idPrerequisParcours;
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