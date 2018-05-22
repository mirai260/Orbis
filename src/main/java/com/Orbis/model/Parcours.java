package com.Orbis.model;


import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parcours{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long idParcours;

    private String parcours;
    private String description;



    public static Model.Find<Long, Parcours> find = new Model.Find<Long, Parcours>() {};  // Outil de recherche dans la bdd



    public Long getIdParcours() {
        return idParcours;
    }

    public void setIdParcours(Long idParcours) {
        this.idParcours = idParcours;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}