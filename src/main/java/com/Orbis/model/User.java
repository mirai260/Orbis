package com.Orbis.model;

import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;
import com.avaje.ebean.Model;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id_user;

    private String login;
    private String password;

    public static Model.Find<Long, User> find = new Model.Find<Long, User>() {};

    public static User getUserByLogin(String login){
        Expression expr = Expr.eq("login", login);
        return find.where().add(expr).findUnique();
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
