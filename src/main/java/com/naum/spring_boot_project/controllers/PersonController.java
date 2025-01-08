package com.naum.spring_boot_project.controllers;


import com.naum.spring_boot_project.models.Person;
import com.naum.spring_boot_project.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;
    // private PersonServices personServices = new PersonServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()
    {
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findByID(
            @PathVariable(value = "id") Long id
    )
    {
        return personServices.findByID(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(
            @RequestBody Person person
    )
    {
        return personServices.save(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(
            @RequestBody Person person
    )
    {
        return personServices.update(person);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(
            @PathVariable(value = "id") Long id
    )
    {
        personServices.delete(id);
        return ResponseEntity.noContent().build();
    }



}
