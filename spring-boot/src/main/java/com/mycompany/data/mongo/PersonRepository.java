package com.mycompany.data.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mycompany.boot.data.modal.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findOneByName(String name);
		
}
