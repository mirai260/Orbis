package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Eleve {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long idEleve;

    private String login;
    private String mdp;

    public static Model.Find<Long, Eleve> find = new Model.Find<Long, Eleve>() {};

    public static Eleve getUserByLogin(String login){
        Expression expr = Expr.eq("login", login);
        return find.where().add(expr).findUnique();
    }

    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
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
