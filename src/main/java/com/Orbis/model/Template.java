package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

public class Template extends Model{

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;


    @ApiModelProperty(value = "Longueur <= 30") //Affiche une condition pour la valeur du champs dans l'api
    private String ex1;
    private long ex2;



    public static Find<Long, Template> find = new Model.Find<Long, Template>() {};  // Outil de recherche dans la bdd


    public static List<Template> getTemplates(Long ex2, String ex1_part){
        Expression e1 = Expr.eq("ex2", ex2);
        Expression e2 = Expr.like("ex1", "%" + ex1_part + "%");
        return Template.find.where().add(e1).add(e2).findList();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public long getEx2() {
        return ex2;
    }

    public void setEx2(long ex2) {
        this.ex2 = ex2;
    }
}
