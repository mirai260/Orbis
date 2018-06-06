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
public class Domaine extends Model{

	@Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_domaine;
	
	private String name;
	
	public static Model.Find<Long, Domaine> find = new Model.Find<Long, Domaine>() {};
	
	public static List<Domaine> getAllDomaine(){
        return find.all();
    }
	
	public static Long getIdDomaineByName(String domaine){
		Expression e1 = Expr.eq("name", domaine);
        return find.where().add(e1).findUnique().id_domaine;
    }
	
	public Long getId_domaine() {
        return id_domaine;
    }

    public void setId_domaine(Long id_domaine) {
        this.id_domaine = id_domaine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
