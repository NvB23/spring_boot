package com.naum.spring_boot_project.controllers;

import com.naum.spring_boot_project.data.dto.v1.PersonDTO;
import com.naum.spring_boot_project.data.dto.v2.PersonDTOV2;
import com.naum.spring_boot_project.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person/v1")
public class PersonController {

    @Autowired
    private PersonServices personServices;
    // private PersonServices personServices = new PersonServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll()
    {
        return personServices.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findByID(
            @PathVariable(value = "id") Long id
    )
    {
        return personServices.findByID(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(
            @RequestBody PersonDTO person
    )
    {
        return personServices.save(person);
    }

    @PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 createV2(
            @RequestBody PersonDTOV2 person
    )
    {
        return personServices.saveV2(person);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(
            @RequestBody PersonDTO person
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
