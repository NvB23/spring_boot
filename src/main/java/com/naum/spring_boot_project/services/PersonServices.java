package com.naum.spring_boot_project.services;
import com.naum.spring_boot_project.exceptions.ResourceNotFoundException;
import com.naum.spring_boot_project.mapper.DozerMapper;
import com.naum.spring_boot_project.models.Person;
import com.naum.spring_boot_project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naum.spring_boot_project.data.vo.v1.PersonVO;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findByID (Long id){
        logger.info("Finding one person.");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id."));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO save (PersonVO person) {
        logger.info("Creating new person.");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public PersonVO update (PersonVO person) {
        logger.info("Updating one person.");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete (Long id) {
        logger.info("Deleting one person.");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        personRepository.delete(entity);
    }

}
