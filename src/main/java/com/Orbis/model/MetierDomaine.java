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
public class MetierDomaine {

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
	private Long id_metier_domaine;
	
    private Long idMetier;
	private Long idDomaine;
	
	public static Model.Find<Long, MetierDomaine> find = new Model.Find<Long, MetierDomaine>() {};
	
	public static List<Long> getIdMetierByDomaine(Long idDomaine){
		List<Long> res = new ArrayList<>();
		Expression e1 = Expr.eq("idDomaine", idDomaine);
		List<MetierDomaine> list = find.where().add(e1).findList();
		for(MetierDomaine md : list) {
			res.add(md.idMetier);
		}
        return res;
    }
	
	public static MetierDomaine getMetierDomaineById(Long id_metier_domaine){
		Expression expr = Expr.eq("id_metier_domaine", id_metier_domaine);
		return find.where().add(expr).findUnique();
	}
	
	

	public Long getId_metier_domaine() {
		return id_metier_domaine;
	}

	public void setId_metier_domaine(Long id_metier_domaine) {
		this.id_metier_domaine = id_metier_domaine;
	}

	public Long getIdMetier() {
        return idMetier;
    }

    public void setIdMetier(Long idMetier) {
        this.idMetier = idMetier;
    }

    public Long getIdDomaine() {
        return idDomaine;
    }

    public void setIdDomaine(Long idDomaine) {
        this.idDomaine = idDomaine;
    }
}