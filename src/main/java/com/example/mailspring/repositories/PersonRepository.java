package com.example.mailspring.repositories;


import com.example.mailspring.models.PersonRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonRegistration, Long> {

    PersonRegistration findByName(String name);
}
