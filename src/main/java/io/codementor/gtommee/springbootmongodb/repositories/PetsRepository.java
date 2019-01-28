package io.codementor.gtommee.springbootmongodb.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import io.codementor.gtommee.springbootmongodb.models.Pets;

public interface PetsRepository extends MongoRepository<Pets, String> {
	Pets findBy_id(ObjectId _id);
}
