package com.Orbis.api;

import com.Orbis.model.Parcours;
import com.Orbis.model.Parcours_Professeur;
import com.avaje.ebean.Expr;
import com.avaje.ebean.Expression;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfesseurApiController implements ProfesseurApi{

    @Override
    public ResponseEntity<List<Parcours>> getParcoursOfConnectedProfesseur(){
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	Long id = (Long)authentication.getPrincipal();
        Expression expr = Expr.eq("id_professeur", id);
        List<Parcours_Professeur> list = Parcours_Professeur.find.where().add(expr).findList();
        List<Parcours> parcours = new ArrayList<>();
        for (Parcours_Professeur pp : list) {
        	parcours.add(Parcours.getParcoursById(pp.getId_parcours()));
        }
        return new ResponseEntity<>(parcours, HttpStatus.OK);
    }
}
