package com.naum.spring_boot_project.services;

import com.naum.spring_boot_project.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        logger.info("Find all persons.");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Person lastname " + i);
        person.setAddress("Some address in Brasil" + i);
        person.setGender("Male");
        return person;
    }

    public Person findByID (String id){
        logger.info("Find one person.");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("Naum");
        person.setLastName("Victor");
        person.setAddress("Sousa - Paraíba - Brasil");
        person.setGender("Masculino");

        return person;
    }

    public Person save (Person person) {
        logger.info("Creating new person.");

        return person;
    }

    public Person update (Person person) {
        logger.info("Updating one person.");

        return person;
    }

    public void delete (String id) {
        logger.info("Deleting one person.");

    }

}
