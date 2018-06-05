package com.Orbis.api;

import com.Orbis.model.Domaine;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DomaineApiController implements DomaineApi{

    @Override
    public ResponseEntity<List<Domaine>> getAllDomaine(){
        List<Domaine> domaines = Domaine.getAllDomaine();
        return new ResponseEntity<>(domaines, HttpStatus.OK);
    }

}
