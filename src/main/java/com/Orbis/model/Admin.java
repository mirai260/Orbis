package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Admin extends Model {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_admin;

    private String login;
    private String mdp;

    public static Model.Find<Long, Admin> find = new Model.Find<Long, Admin>() {};

    public static Admin getAdminByLogin(String login){
        Expression expr = Expr.eq("login", login);
        return find.where().add(expr).findUnique();
    }

    public Long getId_admin() {
        return id_admin;
    }

    public void setId_admin(Long id_admin) {
        this.id_admin = id_admin;
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
