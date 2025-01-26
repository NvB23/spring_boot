package com.naum.spring_boot_project.services;
import com.naum.spring_boot_project.data.dto.v2.PersonDTOV2;
import com.naum.spring_boot_project.exceptions.ResourceNotFoundException;
import com.naum.spring_boot_project.mapper.DozerMapper;
import com.naum.spring_boot_project.mapper.custom.PersonMapper;
import com.naum.spring_boot_project.models.Person;
import com.naum.spring_boot_project.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.naum.spring_boot_project.data.dto.v1.PersonDTO;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper mapper;

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonDTO> findAll(){
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO findByID (Long id){
        logger.info("Finding one person.");

        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id."));
        return DozerMapper.parseObject(entity, PersonDTO.class);
    }

    public PersonDTO save (PersonDTO person) {
        logger.info("Creating new person.");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 saveV2 (PersonDTOV2 person) {
        logger.info("Creating new person with v2.");
        var entity = mapper.convertDTOToEntity(person);
        return mapper.convertEntityToDTO(personRepository.save(entity));
    }


    public PersonDTO update (PersonDTO person) {
        logger.info("Updating one person.");
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    public void delete (Long id) {
        logger.info("Deleting one person.");
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records find for this Id"));

        personRepository.delete(entity);
    }

}
