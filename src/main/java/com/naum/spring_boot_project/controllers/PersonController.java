package com.naum.spring_boot_project.controllers;


import ch.qos.logback.core.joran.spi.HttpUtil;
import com.naum.spring_boot_project.exceptions.UnsupportedMathOperationException;
import com.naum.spring_boot_project.models.Person;
import com.naum.spring_boot_project.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonServices personServices;
    // private PersonServices personServices = new PersonServices;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll()
    {
        return personServices.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findByID(
            @PathVariable(value = "id") String id
    )
    {
        return personServices.findByID(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(
            @RequestBody Person person
    )
    {
        return personServices.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(
            @RequestBody Person person
    )
    {
        return personServices.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(
            @PathVariable(value = "id") String id
    )
    {
        personServices.delete(id);
    }



}
