package com.worktool.personapi.controller;

import com.worktool.personapi.dto.MessageResponseDTO;
import com.worktool.personapi.entity.Person;
import com.worktool.personapi.repository.PersonRepository;
import com.worktool.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(Person person) {
        return personService.createPerson(person);
    }
}
