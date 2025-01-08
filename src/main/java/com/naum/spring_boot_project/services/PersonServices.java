package com.naum.spring_boot_project.services;

import com.naum.spring_boot_project.exceptions.ResourceNotFoundException;
import com.naum.spring_boot_project.models.Person;
import com.naum.spring_boot_project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findByID (Long id){
        logger.info("Find one person.");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id."));
    }

    public Person save (Person person) {
        logger.info("Creating new person.");

        return personRepository.save(person);
    }

    public Person update (Person person) {
        logger.info("Updating one person.");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }

    public void delete (Long id) {
        logger.info("Deleting one person.");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        personRepository.delete(entity);
    }

}
