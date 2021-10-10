package com.worktool.personapi.service;

import com.worktool.personapi.dto.request.PersonDTO;
import com.worktool.personapi.dto.response.MessageResponseDTO;
import com.worktool.personapi.entity.Person;
import com.worktool.personapi.exception.PersonNotFoundException;
import com.worktool.personapi.mapper.PersonMapper;
import com.worktool.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);


        Person savedPerson = personRepository.save(personToSave);
        return createMethodResponse(savedPerson.getId(), "Created person with ID");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);


        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);

        personRepository.deleteById(id);
    }



    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyIfExists(id);
        Person personToUpadate = personMapper.toModel(personDTO);


        Person updatePerson = personRepository.save(personToUpadate);
        return createMethodResponse(updatePerson.getId(), "Update person with ID");
    }

    //Metodos PRIVADOS

    private Person verifyIfExists(Long id) throws PersonNotFoundException {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMethodResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
