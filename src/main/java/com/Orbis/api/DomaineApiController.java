package com.Orbis.api;

import com.Orbis.model.Domaine;
import com.Orbis.model.Template;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class DomaineApiController implements DomaineApi{


    @Override
    public ResponseEntity<List<Domaine>> getAllDomaine(){
        List<Domaine> domaines = Domaine.getAllDomaine();
        return new ResponseEntity<>(domaines, HttpStatus.OK);
    }

}
