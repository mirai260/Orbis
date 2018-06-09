package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Eleve extends Model {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_eleve;

    private String login;
    private String mdp;

    public static Model.Find<Long, Eleve> find = new Model.Find<Long, Eleve>() {};

    public static Eleve getEleveByLogin(String login){
        Expression expr = Expr.eq("login", login);
        return find.where().add(expr).findUnique();
    }
    
    public static Eleve getEleveById(long id_eleve) {
    	Expression expr = Expr.eq("id_eleve", id_eleve);
    	return find.where().add(expr).findUnique();
    }

    public Long getId_eleve() {
		return id_eleve;
	}

	public void setId_eleve(Long id_eleve) {
		this.id_eleve = id_eleve;
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
