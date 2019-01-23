package io.codementor.gtommee.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.codementor.gtommee.models.Pets;
import io.codementor.gtommee.repositories.PetsRepository;

@RestController
@RequestMapping(PetsController.path)
public class PetsController {

	static final String path = "/pets";

	@Autowired
	private PetsRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Pets> getAllPets() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pets getPetById(@PathVariable("id")
			ObjectId id) {
		return repository.findBy_id(id);
	}

}
