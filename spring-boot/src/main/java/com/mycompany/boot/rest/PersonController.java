package com.mycompany.boot.rest;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.boot.data.modal.Person;
import com.mycompany.data.mongo.PersonRepository;


@RestController
@RequestMapping("/person")
public class PersonController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PersonRepository repository;
	
	@RequestMapping( produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getPersons(@RequestParam(required = false, value = "gender") String sortBy, @RequestParam(required = false, value = "company") String year) {
		List<Person> persons = repository.findAll();
		persons.forEach(item->logger.info(item.toString()));				
		return persons;
	}
	
	@RequestMapping(path="/{name}", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public Person getPersons(@PathVariable ("name") String name) {
		Person person = repository.findOneByName(name);
		logger.info("Data found as :",person);				
		return person;
	}

	@RequestMapping(consumes="application/json", produces = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public Person addPerson(@RequestBody Person person) {
		logger.info("Inserting:",person.toString());
		Person rPerson = repository.insert(person);
		return rPerson ;
	}

	@RequestMapping(consumes="application/json", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public Person updatePerson(@RequestBody Person person) {
		logger.info("Updating:",person.toString());
		Person rPerson = repository.save(person);
		return rPerson ;
	}

	@RequestMapping(path="/{id}", produces = "application/json", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePerson(@RequestParam("id") String id) {
		logger.info("Deleting:",id);
		repository.delete(id);
		return "";
	}
}
