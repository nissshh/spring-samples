package com.company.project;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public PersonDTOResponse getPerson(PersonDTORequest personDTORequest) {

        return new PersonDTOResponse(personDTORequest.getName(), personDTORequest.getAge());
    }

}
