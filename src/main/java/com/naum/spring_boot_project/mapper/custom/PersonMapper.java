package com.naum.spring_boot_project.mapper.custom;

import com.naum.spring_boot_project.data.dto.v2.PersonDTOV2;
import com.naum.spring_boot_project.models.Person;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class PersonMapper {
    public PersonDTOV2 convertEntityToDTO(Person person) {
        // Dava para usar o Dozer:
        // PersonVOV2 vov2 = DozerMapper.parseObject(person, PersonVOV2.class);
        // vov2.setBirthDay(new Date());


        PersonDTOV2 vo = new PersonDTOV2();
        vo.setId(person.getId());
        vo.setBirthDay(new Date());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertDTOToEntity(PersonDTOV2 person) {
        // Dava para usar o Dozer:
        // Person entity = DozerMapper.parseObject(person, Person.class);

        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        // entity.setBirthDay(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
