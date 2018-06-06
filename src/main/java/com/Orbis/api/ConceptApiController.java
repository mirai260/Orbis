package com.Orbis.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.Orbis.model.Concept;

@Controller
public class ConceptApiController implements ConceptApi {

	@Override
	public ResponseEntity<List<Concept>> getAllConcepts() {
		List<Concept> concepts = Concept.getAllConcepts();
		return new ResponseEntity<>(concepts, HttpStatus.OK);
	}

}
