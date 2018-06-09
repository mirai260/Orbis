package com.Orbis.api;

import com.Orbis.model.Template;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Controller
public class TemplateApiController implements TemplateApi{


    @Override
    public ResponseEntity<ApiResponseMessage> nomDeLaFonction(
            @ApiParam(value = "Description du paramètres" ,required=true )
            @RequestBody Template/*type de paramètre*/ nomDuParametre,    //Paramètre passé en POST (données de formulaire)

            @ApiParam(value = "Description du paramètre" ,required=true )
            @PathVariable("param") Long param                           //Paramètre passé dans l'url
    ){
        //Corps de la fonction
        String s = "test";
        ApiResponseMessage m = new ApiResponseMessage(4, "test");
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

}
