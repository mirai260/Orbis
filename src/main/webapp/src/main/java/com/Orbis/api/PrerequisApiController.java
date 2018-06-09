package com.Orbis.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.Orbis.model.Prerequis;

@Controller
public class PrerequisApiController implements PrerequisApi{

	@Override
	public ResponseEntity<List<Prerequis>> getAllPrerequis() {
		List<Prerequis> prerequis = Prerequis.getAllPrerequis();
		return new ResponseEntity<>(prerequis, HttpStatus.OK);
	}

}
