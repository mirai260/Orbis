package com.Orbis.api;

import com.Orbis.model.Template;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "template", description = "the template API")
public interface TemplateApi {

    @ApiOperation(value = "Description de l'api", notes = "", response = Void.class, tags={ "template", })
    @ApiResponses(value = {
            @ApiResponse(code = 200 /*code reponse*/, message = "Message indiquant le résultat", response = Void.class /*type de retour*/),
            @ApiResponse(code = 404 /*code reponse*/, message = "Message indiquant le résultat", response = Void.class /*type de retour*/)
    })
    @RequestMapping(value = "api/url_de_l'api/{param}",
            produces = { "application/json" },
            method = RequestMethod.POST /*méthode d'accès à l'api*/)
    ResponseEntity<ApiResponseMessage/*type de retour*/> nomDeLaFonction(

            @ApiParam(value = "Description du paramètres" ,required=true )
                @RequestBody Template/*type de paramètre*/ nomDuParametre,    //Paramètre passé en POST (données de formulaire)

            @ApiParam(value = "Description du paramètre" ,required=true )
                @PathVariable("param") Long param                           //Paramètre passé dans l'url

    );

}