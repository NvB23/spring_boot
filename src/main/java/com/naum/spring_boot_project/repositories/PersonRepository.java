package com.naum.spring_boot_project.repositories;

import com.naum.spring_boot_project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
