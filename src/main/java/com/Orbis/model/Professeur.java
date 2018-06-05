package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Professeur extends Model {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_professeur;

    private String login;
    private String mdp;

    public static Model.Find<Long, Professeur> find = new Model.Find<Long, Professeur>() {};

    public static Professeur getProfesseurByLogin(String login){
        Expression expr = Expr.eq("login", login);
        return find.where().add(expr).findUnique();
    }

    public Long getId_professeur() {
        return id_professeur;
    }

    public void setId_professeur(Long id_professeur) {
        this.id_professeur = id_professeur;
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
