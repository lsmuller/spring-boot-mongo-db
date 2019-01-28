package io.codementor.gtommee.springbootmongodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.codementor.gtommee.springbootmongodb.models.Pets;
import io.codementor.gtommee.springbootmongodb.repositories.PetsRepository;

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

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets) {
		pets.set_id(id);
		repository.save(pets);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Pets createPet(@Valid @RequestBody Pets pets) {
		pets = repository.save(pets);
		return pets;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
	
}
